package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.testServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.PartieServiceImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.mocks.ServicesMock;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.detElemDispPouPartExceptions.AucunQuestionnaireDispoException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.detElemDispPouPartExceptions.JoueurInexistantException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPartieService {

    PartieServiceImpl partieService;

    @BeforeEach
    public void setUp() {
        partieService = new PartieServiceImpl(
                ServicesMock.getMockQuestionnaireService(),
                ServicesMock.getMockJoueurService()
        );
    }

    @Test
    public void testDeterminerElementsDispoPourPartie_OK() throws Exception {
        List<QuestionnaireDTO> resultats = partieService.determinerElementsDispoPourPartie("yasminou");
        assertEquals(2, resultats.size());
        assertTrue(resultats.stream().anyMatch(q -> q.getTheme().equals("cinema")));
        assertTrue(resultats.stream().anyMatch(q -> q.getTheme().equals("histoire")));
    }

    @Test
    public void testDeterminerElementsDispoPourPartie_JoueurInexistant() {
        assertThrows(JoueurInexistantException.class, () ->
                partieService.determinerElementsDispoPourPartie("inconnu"));
    }

    @Test
    public void testDeterminerElementsDispoPourPartie_AucunQuestionnaire() {
        IQuestionnaireServices serviceVide = pseudo -> List.of();

        PartieServiceImpl serviceSansQuestionnaires = new PartieServiceImpl(
                (serviceVide),
                ServicesMock.getMockJoueurService()
        );

        assertThrows(AucunQuestionnaireDispoException.class, () ->
                serviceSansQuestionnaires.determinerElementsDispoPourPartie("yasminou"));
    }
}
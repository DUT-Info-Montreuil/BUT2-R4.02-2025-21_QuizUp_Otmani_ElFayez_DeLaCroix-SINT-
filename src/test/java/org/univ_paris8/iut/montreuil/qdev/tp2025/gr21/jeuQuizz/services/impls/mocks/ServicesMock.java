package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.util.Arrays;
import java.util.Collections;

public class ServicesMock {

    public static IJoueurServices getMockJoueurService() {
        return pseudo -> {
            if (pseudo.equals("yasminou")) {
                return new JoueurDTO("yasminou", "Yasmine", 2002,
                        0, Arrays.asList("cinema", "histoire"), Langues.FRANCAIS);
            }
            return null;
        };
    }


    public static IQuestionnaireServices getMockQuestionnaireService() {
        return (filtre) -> Arrays.asList(
           new QuestionnaireDTO(1, "Culture G", Langues.FRANCAIS, Collections.emptyList(), 2, "cinema"),
           new QuestionnaireDTO(2, "L'Europe", Langues.FRANCAIS, Collections.emptyList(), 3, "histoire"),
           new QuestionnaireDTO(3, "Physique", Langues.FRANCAIS, Collections.emptyList(), 2, "science")
        );
    }
}

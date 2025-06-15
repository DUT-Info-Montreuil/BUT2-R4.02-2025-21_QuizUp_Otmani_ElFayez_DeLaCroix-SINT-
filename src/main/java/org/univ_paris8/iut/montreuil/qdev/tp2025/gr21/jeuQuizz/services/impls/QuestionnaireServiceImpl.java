package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.util.Arrays;
import java.util.List;

public class QuestionnaireServiceImpl implements IQuestionnaireServices {

    @Override
    public List<QuestionnaireDTO> recupererTousLesQuestionnaires(String pseudo) {
        return Arrays.asList(
                new QuestionnaireDTO(1, "Culture G", Langues.FRANCAIS, null, 2, "cinema"),
                new QuestionnaireDTO(2, "Sciences naturelles", Langues.FRANCAIS, null, 3, "animaux"),
                new QuestionnaireDTO(3, "Histoire de France", Langues.FRANCAIS, null, 3, "histoire")
        );
    }
}

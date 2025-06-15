package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.QuestionnaireDTO;

import java.util.List;

public interface IQuestionnaireServices {

    /**
     * Récupère tous les questionnaires disponibles dans le système.
     *
     * @return une liste de tous les QuestionnaireDTO disponibles
     */
    List<QuestionnaireDTO> recupererTousLesQuestionnaires(String pseudo);
}

package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.determinerElementsDispoPourPartieExceptions.AucunQuestionnaireDisponibleException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.determinerElementsDispoPourPartieExceptions.JoueurInexistantException;

import java.util.List;
import java.util.stream.Collectors;

public class PartieServiceImpl {

    private final IQuestionnaireServices questionnaireService;
    private final IJoueurServices joueurService;

    public PartieServiceImpl(IQuestionnaireServices questionnaireService, IJoueurServices joueurService) {
        this.questionnaireService = questionnaireService;
        this.joueurService = joueurService;
    }

    public List<QuestionnaireDTO> determinerElementsDispoPourPartie(String pseudoJoueur)
            throws JoueurInexistantException, AucunQuestionnaireDisponibleException {

        JoueurDTO joueur = joueurService.recupererJoueurParPseudo(pseudoJoueur);
        if (joueur == null) {
            throw new JoueurInexistantException("Le joueur avec le pseudo " + pseudoJoueur + " n'existe pas.");
        }

        Langues languePreferee = joueur.getLangagePrefere();
        List<String> interets = joueur.getCentresInterets();

        List<QuestionnaireDTO> questionnairesFiltres = questionnaireService.recupererTousLesQuestionnaires(joueur.getPseudo())
                .stream()
                .filter(q -> q.getLangue().name().equalsIgnoreCase(languePreferee.name()))
                .filter(q -> interets.contains(q.getTheme()))
                .collect(Collectors.toList());

        if (questionnairesFiltres.isEmpty()) {
            throw new AucunQuestionnaireDisponibleException("Aucun questionnaire disponible pour ce joueur.");
        }

        return questionnairesFiltres;
    }
}

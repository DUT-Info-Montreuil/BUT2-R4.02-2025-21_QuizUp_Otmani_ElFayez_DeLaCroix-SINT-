package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.util.List;

public class QuestionnaireDTO {
    private final int id;
    private final String libelle;
    private final Langues langue;
    private final List<Object> questions;
    private final int difficulteMoyenne;
    private final String theme;

    public QuestionnaireDTO(int id, String libelle, Langues langue, List<Object> questions, int difficulteMoyenne, String theme) {
        this.id = id;
        this.libelle = libelle;
        this.langue = langue;
        this.questions = questions;
        this.difficulteMoyenne = difficulteMoyenne;
        this.theme = theme;
    }

    public int getId() { return id; }
    public String getLibelle() { return libelle; }
    public Langues getLangue() { return langue; }
    public List<Object> getQuestions() { return questions; }
    public int getDifficulteMoyenne() { return difficulteMoyenne; }
    public String getTheme() { return theme; }
}

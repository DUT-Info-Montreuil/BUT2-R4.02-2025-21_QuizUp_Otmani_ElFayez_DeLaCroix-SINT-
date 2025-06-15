package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;


public interface IJoueurServices {

    /**
     * Récupère un joueur à partir de son pseudo unique.
     *
     * @param pseudo le pseudo du joueur
     * @return JoueurDTO correspondant, ou null si inexistant
     */
    JoueurDTO recupererJoueurParPseudo(String pseudo);

}

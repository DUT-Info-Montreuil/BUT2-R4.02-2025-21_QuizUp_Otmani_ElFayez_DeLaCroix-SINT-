package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.util.*;

public class JoueurServicesImpl implements IJoueurServices {

    private final Map<String, JoueurDTO> joueurs = new HashMap<>();


    public JoueurServicesImpl() {
        joueurs.put("yasminou", new JoueurDTO("yasminou", "Yasmine", 2002,
                0, Arrays.asList("cinema", "histoire"), Langues.FRANCAIS));
        joueurs.put("lucas", new JoueurDTO("lucas", "Lucas", 2001,
                0, Arrays.asList("science", "animaux"), Langues.FRANCAIS));
    }

    @Override
    public JoueurDTO recupererJoueurParPseudo(String pseudo) {
        return joueurs.get(pseudo);
    }
}

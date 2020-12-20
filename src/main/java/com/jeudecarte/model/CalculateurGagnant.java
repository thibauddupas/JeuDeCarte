package com.jeudecarte.model;

import java.util.ArrayList;

public class CalculateurGagnant {
    public Joueur trouverGagnant(ArrayList<Joueur> joueurs){
        Joueur gagnant = joueurs.get(0);
        for (Joueur joueur: joueurs){
            if (joueur.getMain().get(0).getRang().getIndex() > gagnant.getMain().get(0).getRang().getIndex()
                    || (joueur.getMain().get(0).getRang().getIndex() == gagnant.getMain().get(0).getRang().getIndex() &&
                    joueur.getMain().get(0).getCouleur().getIndex() > gagnant.getMain().get(0).getCouleur().getIndex())){
                gagnant = joueur;
            }
        }
        return gagnant;
    }
}

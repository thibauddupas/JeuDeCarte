package com.jeudecarte.model;

import com.jeudecarte.model.Pile;

import java.util.ArrayList;

public class JeuDe32 extends Pile {
    public JeuDe32() {
        ArrayList<Carte> cartes = new ArrayList<Carte>();
        for (Rang rang: Rang.values()){
            for (Couleur couleur: Couleur.values()){
                if (!rang.equals(Rang.Joker) && !couleur.equals(Couleur.Joker) && rang.getIndex() >= 7)
                    cartes.add(new Carte(couleur, rang));
            }
        }

        melanger();
    }
}

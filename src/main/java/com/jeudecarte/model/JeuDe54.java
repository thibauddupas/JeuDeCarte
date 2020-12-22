package com.jeudecarte.model;

import java.util.ArrayList;

public class JeuDe54 extends Pile{
    public JeuDe54() {
        ArrayList<Carte> cartes = new ArrayList<Carte>();
        for (Rang rang: Rang.values()){
            for (Couleur couleur: Couleur.values()){
                if (!rang.equals(Rang.Joker) && !couleur.equals(Couleur.Joker))
                cartes.add(new Carte(couleur, rang));
            }
        }
        cartes.add(new Carte(Couleur.Joker,Rang.Joker));
        cartes.add(new Carte(Couleur.Joker,Rang.Joker));

        melanger();
    }
}

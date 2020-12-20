package com.jeudecarte.model;

import java.util.ArrayList;
import java.util.Collections;

public class Pile {
    private ArrayList<Carte> pileDeCarte;

    public Pile(){
        pileDeCarte = new ArrayList<>();
        for (Rang rang: Rang.values()){
            for (Couleur couleur: Couleur.values()){
                pileDeCarte.add(new Carte(couleur,rang));
            }
        }
        melanger();
    }

    public void melanger() {
        Collections.shuffle(pileDeCarte);
    }

    public Carte piocher() {
        Carte cartePiochee = pileDeCarte.get(pileDeCarte.size() - 1);
        pileDeCarte.remove(pileDeCarte.size() - 1);
        return cartePiochee;
    }

    public void defausserCarte(Carte carte) {
        pileDeCarte.add(carte);
    }

    /*public void defausserCarte(Carte cartePiochee) {
        pileDeCarte.add(cartePiochee);
    }*/
}

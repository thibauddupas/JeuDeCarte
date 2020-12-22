package com.jeudecarte.model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Pile {
    private ArrayList<Carte> pileDeCarte;

    public void melanger() {
        Collections.shuffle(pileDeCarte);
    }

    public Carte piocher() {
        Carte cartePiochee = pileDeCarte.get(pileDeCarte.size() - 1);
        pileDeCarte.remove(pileDeCarte.size() - 1);
        return cartePiochee;
    }

    public void defausserCarte(ArrayList<Carte> cartes) {
        pileDeCarte.addAll(cartes);
    }
}

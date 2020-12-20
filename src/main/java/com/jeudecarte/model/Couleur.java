package com.jeudecarte.model;

public enum Couleur {
    Carreau (1),
    Coeur (2),
    Pique (3),
    Trefle (4);

    private int index;

    Couleur(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

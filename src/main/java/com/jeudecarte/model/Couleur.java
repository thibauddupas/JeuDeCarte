package com.jeudecarte.model;

public enum Couleur {
    Carreau (1),
    Coeur (2),
    Pique (3),
    Trefle (4),
    Joker (5),
    Atout(6);

    private int index;

    Couleur(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void definirCommeAtout() {
        index = Atout.getIndex();
    }
}

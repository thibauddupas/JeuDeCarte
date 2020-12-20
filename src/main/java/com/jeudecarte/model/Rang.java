package com.jeudecarte.model;

public enum Rang {
    Deux (2),
    Trois (3),
    Quatre (4),
    Cinq (5),
    Six (6),
    Sept (7),
    Huit (8),
    Neuf (9),
    Dix (10),
    Valet (11),
    Dame (12),
    Roi (13),
    As (14);

    private int index;

    Rang(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

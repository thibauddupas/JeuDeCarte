package com.jeudecarte.model;

public class Carte {
    private Rang rang;
    private Couleur couleur;
    private Boolean faceVisible;

    public Carte(Couleur couleur, Rang rang) {
        this.couleur = couleur;
        this.rang = rang;
        this.faceVisible = false;
    }

    public void retournerDeFace() {
        faceVisible = !faceVisible;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Rang getRang() {
        return rang;
    }

    public Boolean getFaceVisible() {
        return faceVisible;
    }
}

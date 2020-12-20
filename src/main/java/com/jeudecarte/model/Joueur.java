package com.jeudecarte.model;

public class Joueur {
    private String nom;
    private Main main;

    public Joueur(String nom) {
        this.nom = nom;
        main = new Main();
    }

    public String getNom() {
        return nom;
    }

    public void piocher(Carte carte) {
        main.piocher(carte);
    }

    public void defausser(Carte carte) {
        main.defausser(carte);
    }

    public Main getMain() {
        return main;
    }
}

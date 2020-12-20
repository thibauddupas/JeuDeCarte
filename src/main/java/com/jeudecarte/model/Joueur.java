package com.jeudecarte.model;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main;

    public Joueur(String nom) {
        this.nom = nom;
        main = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void piocher(Carte carte) {
        main.add(carte);
    }

    public void defausser(Carte carte) {
        main.remove(carte);
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public ArrayList<Carte> defausserToutesLesCartes() {
        ArrayList<Carte> cartesADefausser = new ArrayList<>();
        for (int indexCarte =0; main.size() > 0; indexCarte++){
            cartesADefausser.add(main.get(0));
            defausser(main.get(0));
        }
        return cartesADefausser;
    }
}

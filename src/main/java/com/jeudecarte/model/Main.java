package com.jeudecarte.model;

import java.util.ArrayList;

public class Main {
    ArrayList<Carte> cartesEnMain = new ArrayList<>();

    public void piocher(Carte carte) {
        cartesEnMain.add(carte);
    }

    public ArrayList<Carte> getToutesCartes() {
        return cartesEnMain;
    }

    public void defausser(Carte carteADefausser) {
        cartesEnMain.remove(carteADefausser);
    }
}

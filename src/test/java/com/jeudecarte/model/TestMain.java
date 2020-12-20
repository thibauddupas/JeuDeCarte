package com.jeudecarte.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {

    @Test
    void testPiocher() {
        Main main = new Main();
        Carte carteAPrendreEnMain = new Carte(Couleur.Pique, Rang.Sept);
        main.piocher(carteAPrendreEnMain);
        ArrayList<Carte> mainEnCarte = main.getToutesCartes();
        Boolean carteTrouvee = false;
        for (Carte carte : mainEnCarte) {
            if (carte.equals(carteAPrendreEnMain)) {
                carteTrouvee = true;
            }
        }
        assertTrue(carteTrouvee, "La carte n'a pas été piochée");
    }

    @Test
    void testVoirLesCartes(){
        Main main = new Main();
        Carte carteEnMain1 = new Carte(Couleur.Trefle,Rang.Huit);
        main.piocher(carteEnMain1);
        Carte carteEnMain2 = new Carte(Couleur.Carreau,Rang.Neuf);
        main.piocher(carteEnMain2);
        Carte carteEnMain3 = new Carte(Couleur.Coeur,Rang.Dame);
        main.piocher(carteEnMain3);
        main.defausser(carteEnMain2);
        ArrayList<Carte> carteEnMain = main.getToutesCartes();
        Boolean carteTrouvee = false;
        for (Carte carte: carteEnMain){
            if (carte.equals(carteEnMain2)){
                carteTrouvee = true;
            }
        }
        assertFalse(carteTrouvee, "La carte neuf de carreau n'a pas été défaussée");
    }
}
package com.jeudecarte.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCouleur {

    private static Couleur carreau;
    private static Couleur coeur;
    private static Couleur pique;
    private static Couleur trefle;
    private static Couleur atout;

    @BeforeAll
    public static void beforeAll(){
        carreau = Couleur.Carreau;
        coeur = Couleur.Coeur;
        pique = Couleur.Pique;
        trefle = Couleur.Trefle;
        atout = Couleur.Atout;
    }

    @Test
    void changerIndex(){
        carreau.definirCommeAtout();
        for (Couleur couleur: Couleur.values()){
            System.out.println(couleur.toString() + " a pour index " + couleur.getIndex());
        }
        assertTrue(carreau.getIndex() == atout.getIndex(), "Le carreau n'est pas devenu l'atout");
    }

    @Test
    void coeurPlusFortQueCarreau(){
        assertTrue(carreau.getIndex() < coeur.getIndex(), "Le coeur devrait être plus fort que carreau");
    }

    @Test
    void piquePlusFortQueCoeur(){
        assertTrue(coeur.getIndex() < pique.getIndex(), "Le pique devrait être plus fort que coeur");
    }

    @Test
    void treflePlusFortQuePique(){
        assertTrue(pique.getIndex() < trefle.getIndex(), "Le coeur devrait être plus fort que carreau");
    }
}
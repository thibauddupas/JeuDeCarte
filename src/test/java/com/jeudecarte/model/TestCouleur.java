package com.jeudecarte.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCouleur {

    private static Couleur carreau;
    private static Couleur coeur;
    private static Couleur pique;
    private static Couleur trefle;

    @BeforeAll
    public static void beforeAll(){
        carreau = Couleur.Carreau;
        coeur = Couleur.Coeur;
        pique = Couleur.Pique;
        trefle = Couleur.Trefle;
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
package com.jeudecarte.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCarte {
        Carte carte;
        Rang rang;
        Couleur couleur;

        @BeforeEach
        public void beforeAll() {
            rang = Rang.Cinq;
            couleur = Couleur.Pique;
            carte = new Carte(couleur, rang);
        }

        @Test
        public void creerCarte() {
            assertEquals(couleur, carte.getCouleur(), "La couleur de la carte n'est pas pique");
        }

        @Test
            public void retournerCarte() {
            assertEquals(false, carte.getFaceVisible(), "La carte doit être face cachée");
            carte.retournerDeFace();
            assertEquals(true, carte.getFaceVisible(), "La carte doit être face visible");
            carte.retournerDeFace();
            assertEquals(false, carte.getFaceVisible(), "La carte doit être face cachée");
        }
}
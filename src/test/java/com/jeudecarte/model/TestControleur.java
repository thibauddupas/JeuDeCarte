package com.jeudecarte.model;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.vue.Vue;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestControleur {
    @Mock
    Vue vue;
    @Mock
    Pile pile;
    @Mock
    Carte carte1;
    @Mock
    Joueur joueur1;

    @Test
    void testCommencerPartie(){
        Controleur controleur = new Controleur(vue,pile);
        controleur.ajouterJoueur(new Joueur("Toto"));
        controleur.ajouterJoueur(new Joueur("Fifi"));
        controleur.commencerPartie();
        Boolean tailleDeLaMainOK = true;
        ArrayList<Joueur> listeDesJoueurs = controleur.getJoueurs();
        for (Joueur joueur: listeDesJoueurs){
            ArrayList<Carte> listeDesCartes = joueur.getMain();
            if (listeDesCartes.size() != 1){
                tailleDeLaMainOK = false;
            }
        }
        assertTrue(tailleDeLaMainOK, "Les joueurs n'ont pas une cartes chacun");
    }

    @Test
    void testRetrounerCartes() {
        Controleur controleur = new Controleur(vue, pile);
        controleur.ajouterJoueur(new Joueur("Toto"));
        controleur.ajouterJoueur(new Joueur("Fifi"));
        controleur.commencerPartie();
        controleur.retournerCarte();
        Boolean cartesRetournees = true;
        ArrayList<Joueur> listeDesJoueurs = controleur.getJoueurs();
        for (Joueur joueur : listeDesJoueurs) {
            ArrayList<Carte> listeDesCartes = joueur.getMain();
            for (Carte carte : listeDesCartes) {
                if (carte.getFaceVisible() == false) {
                    cartesRetournees = false;
                }
            }
        }
        assertTrue(cartesRetournees, "Les cartes n'ont pas été retournées");
    }

    @Test
    public void testAjouterJoueur() {
        Controleur controleur = new Controleur(vue, pile);
        Joueur joueurAAjouter = new Joueur("Toto");
        controleur.ajouterJoueur(joueurAAjouter);
        ArrayList<Joueur> listeDesJoueurs = controleur.getJoueurs();
        Boolean joueurTrouve = false;
        for (Joueur joueur : listeDesJoueurs) {
            if (joueurAAjouter.equals(joueur)) {
                joueurTrouve = true;
            }
        }
        assertTrue(joueurTrouve, "Le joueur n'a pas été trouvé");
    }
}
package com.jeudecarte.model;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.vue.CommandLineView;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestControleur {
    @Mock
    CommandLineView commandLineView;
    @Mock
    Pile pile;
    @Mock
    CalculateurGagnant calculateurGagnant;
    @Mock
    Carte carte1;
    @Mock
    Joueur joueur1;

    @Test
    void testCommencerPartie(){
        Controleur controleur = new Controleur(commandLineView,pile,calculateurGagnant);
        controleur.ajouterUnJoueur(new Joueur("Toto"));
        controleur.ajouterUnJoueur(new Joueur("Fifi"));
        controleur.commencerLaPartie();
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
        Controleur controleur = new Controleur(commandLineView, pile,calculateurGagnant);
        controleur.ajouterUnJoueur(new Joueur("Toto"));
        controleur.ajouterUnJoueur(new Joueur("Fifi"));
        controleur.commencerLaPartie();
        controleur.devoilerLesCartesDeTousLesJoueurs();
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
        Controleur controleur = new Controleur(commandLineView, pile,calculateurGagnant);
        Joueur joueurAAjouter = new Joueur("Toto");
        controleur.ajouterUnJoueur(joueurAAjouter);
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
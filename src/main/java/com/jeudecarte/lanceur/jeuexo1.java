package com.jeudecarte.lanceur;

import com.jeudecarte.ConstructeurDePile;
import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.CalculateurGagnant;
import com.jeudecarte.vue.GameSwing;

public class jeuexo1 {
    public static void main(String[] args){
        GameSwing gameSwing = new GameSwing();
        gameSwing.createAndShowGUI();
        Controleur controleur = new Controleur(gameSwing, ConstructeurDePile.construirePile(ConstructeurDePile.TypeDeJeu.JeuDe54), new CalculateurGagnant());
        controleur.run();
    }
}

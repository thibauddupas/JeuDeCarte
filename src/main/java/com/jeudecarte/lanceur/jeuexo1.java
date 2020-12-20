package com.jeudecarte.lanceur;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.CalculateurGagnant;
import com.jeudecarte.model.Pile;
import com.jeudecarte.vue.CommandLineView;
import com.jeudecarte.vue.GameSwing;
import com.jeudecarte.vue.GameViewable;

public class jeuexo1 {
    public static void main(String[] args){
        GameSwing gameSwing = new GameSwing();
        gameSwing.createAndShowGUI();
        Controleur controleur = new Controleur(gameSwing, new Pile(), new CalculateurGagnant());
        controleur.run();
    }
}

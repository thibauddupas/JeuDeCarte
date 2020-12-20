package com.jeudecarte.lanceur;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.CalculateurGagnant;
import com.jeudecarte.model.Pile;
import com.jeudecarte.vue.CommandLineView;
import com.jeudecarte.vue.GameViewable;

public class jeuexo1 {
    public static void main(String[] args){
        Controleur controleur = new Controleur(new CommandLineView(), new Pile(), new CalculateurGagnant());
        controleur.run();
    }
}

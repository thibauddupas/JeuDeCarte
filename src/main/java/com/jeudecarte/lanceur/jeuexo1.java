package com.jeudecarte.lanceur;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.Pile;
import com.jeudecarte.vue.Vue;

public class jeuexo1 {
    public static void main(String[] args){
        Controleur controleur = new Controleur(new Vue(),new Pile());
        controleur.run();
    }
}

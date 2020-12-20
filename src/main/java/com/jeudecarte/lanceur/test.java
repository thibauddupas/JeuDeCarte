package com.jeudecarte.lanceur;

import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        ArrayList<Integer> liste1 = new ArrayList<Integer>();
        liste1.add(1);
        liste1.add(2);
        liste1.add(3);
        //ArrayList<Integer> liste2 = liste1;
        for (int indexNombre = 0; liste1.size() > 0; indexNombre++){
            System.out.println("nombre supprimé : " + liste1.get(0));
            liste1.remove(0);
        }
        //System.out.println(liste2.size() + " " + liste1.size());
    }
}

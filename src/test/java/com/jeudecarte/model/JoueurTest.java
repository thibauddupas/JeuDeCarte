package com.jeudecarte.model;

import java.util.ArrayList;

public class JoueurTest {
    public void testerJoueur() {
        String test1 = nommer();
        String test2 = piocher();
    }

    private String piocher() {
        Joueur Toto = new Joueur("Toto");
        Carte carte1 = new Carte(Couleur.Pique,Rang.Cinq);
        Toto.piocher(carte1);
        Carte carte2 = new Carte(Couleur.Coeur,Rang.As);
        Toto.piocher(carte2);
        Carte carte3 = new Carte(Couleur.Carreau,Rang.Valet);
        Toto.piocher(carte3);
        ArrayList<Carte> carteDeToto= Toto.getMain().getToutesCartes();
        Boolean carteTrouvee = false;
        for (Carte carte: carteDeToto){
            if (carte.equals(carte1)){
                carteTrouvee = true;
            }
        }
        if (carteTrouvee){
            return "OK";
        } else {
            System.out.println("test KO: le 5 de pique n'a pas été trouvé");
            return "KO";
        }
    }

    private String nommer() {
        Joueur Toto = new Joueur("Toto");
        if (Toto.getNom().equals("Toto")){
            return "OK";
        } else {
            System.out.println("test KO : le nom du joueur créé " + Toto.getNom() + " est différent de l'attendu Toto");
            return "KO";
        }
    }
}

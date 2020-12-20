package com.jeudecarte.model;

public class PileTest {
    //Une pile contient 52 cartes correspondant aux combinaisonx uniques des 4 couleurs et des 13 rangs.
    public void testerPile() {
        String test1 = piocherCarte();
        String test2 = defausserCarte();
    }

    private static String defausserCarte() {
        Pile pile = new Pile();
        Carte cartePiochee1 = pile.piocher();
        pile.defausserCarte(cartePiochee1);
        Carte cartePiochee2 = pile.piocher();
        if (cartePiochee1.equals(cartePiochee2)){
            return "OK";
        } else {
            System.out.println("La cartes n°1 " + cartePiochee1.getRang().name() + " de " + cartePiochee1.getCouleur().name()
                    + " est différent de la carte n°2 " + cartePiochee2.getRang().name() + " de " + cartePiochee2.getCouleur().name());
            return "KO";
        }

    }

    private static String piocherCarte() {
        Pile pile = new Pile();
        Carte cartePiochee;
        String test = "OK";
        int nombreDeCarreau = 0;
        int nombreDeHuit = 0;
        for (int i = 0 ; i<52 ; i++){
            cartePiochee = pile.piocher();
            Couleur couleurCartePiochee = cartePiochee.getCouleur();
            if (couleurCartePiochee.getIndex() == 1){
                nombreDeCarreau = nombreDeCarreau + 1;
            }
            if (cartePiochee.getRang().getIndex() == 8){
                nombreDeHuit += 1;
            }
        }
        if (nombreDeCarreau != 13){
            test = "KO";
            System.out.println("Nombre de Carreaux (" + nombreDeCarreau + ") différent de 13");
        }
        if (nombreDeHuit != 4){
            test = "KO";
            System.out.println("Nombre de Huit (" + nombreDeHuit + ") différent de 4");
        }
        return test;
    };
}

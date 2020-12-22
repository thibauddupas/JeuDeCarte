package com.jeudecarte.model;

import com.jeudecarte.ConstructeurDePile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestJeuDe54 {

    @Test
    void defausser(){
        Pile pile = ConstructeurDePile.construirePile(ConstructeurDePile.TypeDeJeu.JeuDe54);
        Carte cartePiochee1 = pile.piocher();
        ArrayList<Carte> cartesPiochees = new ArrayList<>();
        cartesPiochees.add(cartePiochee1);
        pile.defausserCarte(cartesPiochees);
        Carte cartePiochee3 = pile.piocher();
        assertTrue(cartePiochee1.equals(cartePiochee3), "Les cartes n'ont pas été défaussées");
    }

    @Test
    void piocher(){
        Pile pile = ConstructeurDePile.construirePile(ConstructeurDePile.TypeDeJeu.JeuDe54);
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
        assertTrue(nombreDeCarreau == 13 && nombreDeHuit == 4, "Le jeu ne contient pas 13 carreaux et 4 huits");
    }
}
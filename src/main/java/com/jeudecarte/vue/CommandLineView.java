package com.jeudecarte.vue;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.Carte;
import com.jeudecarte.model.Joueur;

import java.util.Scanner;

public class CommandLineView implements GameViewable{

    Controleur controleur;
    Scanner clavier = new Scanner(System.in);

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public void demanderNouveauJoueur() {
        System.out.println("Saisir nouveau joueur ou 'Go' pour lancer la partie:");
        String nom = clavier.nextLine();
        if (!nom.isEmpty() && !nom.isBlank()){
            if (nom.equals("Go")){
                controleur.commencerPartie();
            } else {
                controleur.ajouterJoueur(new Joueur(nom));
            }
        }
    }

    public void retournerCartes() {
        System.out.println("Taper sur une touche pour retourner les cartes");
        clavier.nextLine();
        controleur.retournerCarte();
    }

    public void proposerNouvellePartie() {
        System.out.println("Taper sur une touche pour rejouer");
        clavier.nextLine();
        controleur.commencerPartie();
    }

    public void afficherNom(int numeroJoueur, String joueurAjoute) {
        System.out.println("["+numeroJoueur+"]["+joueurAjoute+"]");
    }

    public void montrerCarteFaceCachee(int numeroJoueur, String nomJoueur) {
        System.out.println("["+numeroJoueur+"]["+nomJoueur+"]["+"rang caché"+"]["+"couleur cachée"+"]");
    }

    public void montrerCarteFaceVisible(int numeroJoueur, String nomJoueur, String rang, String couleur) {
        System.out.println("["+numeroJoueur+"]["+nomJoueur+"]["+rang+"]["+couleur+"]");
    }

    public void afficherGagnant(String gagnant) {
        System.out.println("["+gagnant+"]");
    }
}

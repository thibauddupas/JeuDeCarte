package com.jeudecarte.vue;

import com.jeudecarte.controleur.Controleur;

public interface GameViewable {
    void setControleur(Controleur controleur);

    void demanderNouveauJoueur();

    void retournerCartes();

    void proposerNouvellePartie();

    void afficherNom(int numeroJoueur, String joueurAjoute);

    void montrerCarteFaceCachee(int numeroJoueur, String nomJoueur);

    void montrerCarteFaceVisible(int numeroJoueur, String nomJoueur, String rang, String couleur);

    void afficherGagnant(String gagnant);
}

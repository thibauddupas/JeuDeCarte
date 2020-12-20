package com.jeudecarte.vue;

import com.jeudecarte.controleur.Controleur;

public interface GameViewable {
    public void setControleur(Controleur controleur);

    public void demanderNouveauJoueur();

    public void retournerCartes();

    public void proposerNouvellePartie();

    public void afficherNom(int numeroJoueur, String joueurAjoute);

    public void montrerCarteFaceCachee(int numeroJoueur, String nomJoueur);

    public void montrerCarteFaceVisible(int numeroJoueur, String nomJoueur, String rang, String couleur);

    public void afficherGagnant(String gagnant);
}

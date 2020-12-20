package com.jeudecarte.controleur;

import com.jeudecarte.model.CalculateurGagnant;
import com.jeudecarte.model.Carte;
import com.jeudecarte.model.Joueur;
import com.jeudecarte.model.Pile;
import com.jeudecarte.vue.CommandLineView;
import com.jeudecarte.vue.GameViewable;

import java.util.ArrayList;

public class Controleur {

    enum AvancementDuJeu {AjoutDesJoueurs,CartesDistributees,GagnantRevele}

    private GameViewable vue;
    private ArrayList<Joueur> joueurs;
    private Pile pile;
    private AvancementDuJeu avancementDuJeu;
    private CalculateurGagnant calculateurGagnant;

    public Controleur(GameViewable vue, Pile pile, CalculateurGagnant calculateurGagnant){
        this.vue = vue;
        this.pile = pile;
        joueurs = new ArrayList<>();
        avancementDuJeu = AvancementDuJeu.AjoutDesJoueurs;
        vue.setControleur(this);
        this.calculateurGagnant = calculateurGagnant;
    }

    public void ajouterJoueur(Joueur joueur) {
        if (avancementDuJeu == AvancementDuJeu.AjoutDesJoueurs){
            joueurs.add(joueur);
            vue.afficherNom(joueurs.size(), joueur.getNom());
        }
    }

    public void retournerCarte() {
        if (avancementDuJeu == AvancementDuJeu.CartesDistributees){
            //TODO Supprimer les boucles ?
            for (Joueur joueur: joueurs){
                for (Carte carte: joueur.getMain()){
                    carte.retournerDeFace();
                    vue.montrerCarteFaceVisible(joueurs.indexOf(joueur)+1,joueur.getNom(),
                            joueur.getMain().get(joueur.getMain().indexOf(carte)).getRang().toString(),
                            joueur.getMain().get(joueur.getMain().indexOf(carte)).getCouleur().toString());
                }
            }

            //TODO implémenter RG gagnant
            Joueur gagnant = calculateurGagnant.trouverGagnant(joueurs);
            vue.afficherGagnant(gagnant.getNom());
            //TODO Supprimer la boucle ?
            for (Joueur joueur: joueurs){
                /*for (int indexCarte = 0; joueur.getMain().size() > 0; indexCarte++){
                    pile.defausserCarte(joueur.getMain().get(0));
                    joueur.defausser(joueur.getMain().get(0));
                }*/
                pile.defausserCarte(joueur.defausserToutesLesCartes());
            }
            pile.melanger();
            avancementDuJeu = AvancementDuJeu.GagnantRevele;
        }
    }

    public void commencerPartie() {
        //TODO Supprimer la boucle ?
        for (Joueur joueur: joueurs){
            joueur.piocher(pile.piocher());
            vue.montrerCarteFaceCachee(joueurs.indexOf(joueur)+1, joueur.getNom());
        }
        avancementDuJeu = AvancementDuJeu.CartesDistributees;
    }

    public void run(){
        while (true){
            switch (avancementDuJeu) {
                case AjoutDesJoueurs:
                    vue.demanderNouveauJoueur();
                    break;
                case CartesDistributees:
                    vue.retournerCartes();
                    break;
                case GagnantRevele:
                    vue.proposerNouvellePartie();
                    break;
            }
        }
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}

package com.jeudecarte.controleur;

import com.jeudecarte.model.CalculateurGagnant;
import com.jeudecarte.model.Carte;
import com.jeudecarte.model.Joueur;
import com.jeudecarte.model.Pile;
import com.jeudecarte.vue.GameViewable;

import java.util.ArrayList;

/**
 * Controleur du jeu
 * @Thibaud Dupas
 */
public class Controleur {

    private enum AvancementDuJeu {AjoutDesJoueurs,CartesDistributees,GagnantRevele}
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


    /**
     * Lanceur technique du jeu
     */
    public void run(){
        while (true){
            switch (avancementDuJeu) {
                // Etape 1 : RG-B Entrer les noms des joueurs.(RG-B1) Limiter le nombre de joueurs à cinq.(RG-B2)
                // et RG-D Distribuer une carte à chaque joueur (face cachée).d
                case AjoutDesJoueurs:
                    vue.demanderNouveauJoueur();
                    break;

                // Etape 2 : RG-E Retourner les cartes de tous les joueurs, afin qu'elles soient visibles.
                // et RG-F Identifier le joueur ayant la carte dont la valeur est la plus forte : As > Roi > Reine > Valet > 10 > . . . 2.
                // et RG-G En cas d'égalité, le choix du gagnant s'effectue en fonction de la couleur : Trèfle > Pique > Cœur > Carreau
                // et RG-H Présenter le nom et la carte du joueur gagnant.
                // et RG-I Remettre toutes les cartes dans le jeu.
                // et RG-J Recommencer à mélanger les cartes.
                case CartesDistributees:
                    vue.retournerCartes();
                    break;

                //Moi : RG-K Revenir à l'étape 2 (RG-D).
                case GagnantRevele:
                    vue.proposerNouvellePartie();
                    break;
            }
        }
    }


    /**
     *   RG-B: Entrer les noms des joueurs.(RG-B1) Limiter le nombre de joueurs à cinq.(RG-B2)
     * Moi : Afficher le nom de chacun joueur ajouté.(RG-B3)
     * @param joueur à ajouter
     */
    public void ajouterUnJoueur(Joueur joueur) {
        if (avancementDuJeu == AvancementDuJeu.AjoutDesJoueurs){
            /**
             * RG-B1 : Entrer les noms des joueurs.
             * et RG-B2 : Limiter le nombre de joueurs à cinq.
             */
            joueurs.add(joueur);

            /**
             * RG-B3 : Afficher le nom de chacun joueur ajouté.
             */
            vue.afficherNom(joueurs.size(), joueur.getNom());
        }
    }

    /**
     *   RG-E Retourner les cartes de tous les joueurs, afin qu'elles soient visibles.(RG-E1)
     *   Moi : Et les afficher.(RG-E2)
     *et RG-F Identifier le joueur ayant la carte dont la valeur est la plus forte : As > Roi > Reine > Valet > 10 > . . . 2.
     *et RG-G En cas d'égalité, le choix du gagnant s'effectue en fonction de la couleur : Trèfle > Pique > Cœur > Carreau
     *et RG-H Présenter le nom et la carte du joueur gagnant.
     *et RG-I Remettre toutes les cartes dans le jeu.
     *et RG-J Recommencer à mélanger les cartes.
     */
    public void devoilerLesCartesDeTousLesJoueurs() {
        if (avancementDuJeu == AvancementDuJeu.CartesDistributees){

            for (Joueur joueur: joueurs){
                for (Carte carte: joueur.getMain()){
                    /**
                     * RG-E1 Retourner les cartes de tous les joueurs, afin qu'elles soient visibles.
                     */
                    carte.retournerDeFace();

                    //RG-E2 Et les afficher.
                    vue.montrerCarteFaceVisible(joueurs.indexOf(joueur)+1,joueur.getNom(),
                            joueur.getMain().get(joueur.getMain().indexOf(carte)).getRang().toString(),
                            joueur.getMain().get(joueur.getMain().indexOf(carte)).getCouleur().toString());
                }
            }

            /**
             * RG-F Identifier le joueur ayant la carte dont la valeur est la plus forte : As > Roi > Reine > Valet > 10 > . . . 2.
             * et RG-G En cas d'égalité, le choix du gagnant s'effectue en fonction de la couleur : Trèfle > Pique > Cœur > Carreau
             */
            Joueur gagnant = calculateurGagnant.trouverGagnant(joueurs);

            /**
             * RG-H Présenter le nom et la carte du joueur gagnant.
             */
            vue.afficherGagnant(gagnant.getNom());

            /**
             * RG-I Remettre toutes les cartes de tous les joueurs dans le jeu.
             */
            for (Joueur joueur: joueurs){
                /*for (int indexCarte = 0; joueur.getMain().size() > 0; indexCarte++){
                    pile.defausserCarte(joueur.getMain().get(0));
                    joueur.defausser(joueur.getMain().get(0));
                }*/
                pile.defausserCarte(joueur.defausserToutesLesCartes());
            }

            /**
             * RG-J Recommencer à mélanger les cartes.
             */
            pile.melanger();

            avancementDuJeu = AvancementDuJeu.GagnantRevele;
        }
    }


    public void commencerLaPartie() {
        /**
         * RG-D Distribuer une carte à chaque joueur (face cachée).
         */
        for (Joueur joueur: joueurs){
            joueur.piocher(pile.piocher());

            vue.montrerCarteFaceCachee(joueurs.indexOf(joueur)+1, joueur.getNom());
        }
        avancementDuJeu = AvancementDuJeu.CartesDistributees;
    }


    /**
     * Ne sert que pour effectuer les tests
     * @return liste des joueurs de la partie
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }
}

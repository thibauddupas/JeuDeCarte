package com.jeudecarte.vue;

import com.jeudecarte.controleur.Controleur;
import com.jeudecarte.model.Joueur;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameSwing implements GameViewable {

    Controleur controleur;
    JButton btnAddPlayer;
    JButton btnDealCards;
    JButton btnFindWinner;
    JTextArea textArea;
    int nextPlayerName = 0;

    public void createAndShowGUI() {
        // créer l'affichage principal avec assez d'espace
        JFrame frame = new JFrame("MVC-SOLID-Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        // tous les contrôles vont apparaitre verticalement
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        addAddPlayerButton(contentPane);
        addDealCardsButton(contentPane);
        addFindWinnerButton(contentPane);
        addcontroleurCommandTracker(contentPane);
        frame.setVisible(true);
    }

    // au click, dire au contrôleur d'ajouter un joueur avec le nom donné
    // ceci DEVRAIT afficher une fenêtre de dialogue pour autoriser l'utilisateur à entrer un nom
    // mais c'est hors du champs de ce qu'on doit apprendre ici
    // pour plus de simplicité, nous allons seulement lui demander d'ajouter "Player A", "Player B", etc.
    private void addAddPlayerButton(Container contentPane) {
        btnAddPlayer = new JButton("Add A Player");
        addCenteredComponent(btnAddPlayer, contentPane);
        btnAddPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Current players:\n");
                nextPlayerName++;
                controleur.ajouterJoueur(new Joueur("Joueur " + nextPlayerName));
            }
        });
    }

    // au click, dire au contrôleur de distribuer les cartes aux joueurs
    private void addDealCardsButton(Container contentPane) {
        btnDealCards = new JButton("Deal Cards");
        addCenteredComponent(btnDealCards, contentPane);
        btnDealCards.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Cards dealt:\n");
                controleur.commencerPartie();
            }
        });
    }

    // au click, dire au contrôleur de retourner les cartes et déterminer qui a gagné
    private void addFindWinnerButton(Container contentPane) {
        btnFindWinner = new JButton("Find Winner");
        addCenteredComponent(btnFindWinner, contentPane);
        btnFindWinner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Show your cards:\n");
                controleur.retournerCarte();
            }
        });
    }

    // un endroit pour afficher ce que le contrôleur nous dit
    // très similaire à la version en ligne de commande
    private void addcontroleurCommandTracker(Container contentPane) {
        textArea = new JTextArea("Game Status\n", 100, 1);
        JScrollPane scrollPane = new JScrollPane(textArea);
        addCenteredComponent(scrollPane, contentPane);
        textArea.setSize(500, 500);
    }

    // on s'assure que chaque fois que quelque chose est ajouté au champ de texte,
    // on scroll down jusqu'en bas pour pouvoir le voir
    // textArea n'a pas d'option d'auto-scroll
    // il faut donc la faire nous-même
    private void appendText(String text) {
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    // tous les contrôles sont ajoutés pour être centrés horizontalement dans la zone
    private void addCenteredComponent(JComponent component, Container contentPane) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(component);
    }

    // Implémentation de l'interface GameViewable
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    // même implémenation que notre CommandLineView juste montrer ce que le contrôleur nous dit
    @Override
    public void afficherNom(int playerIndex, String playerName) {
        appendText("[" + playerIndex + "][" + playerName + "]");
    }

    @Override
    public void montrerCarteFaceVisible(int playerIndex, String playerName, String cardRank, String cardSuit) {
        appendText("[" + playerName + "][" + cardRank + ":" + cardSuit + "]");
    }

    @Override
    public void afficherGagnant(String winnerName) {
        appendText("Winner!\n" + winnerName);
    }

    @Override
    public void montrerCarteFaceCachee(int playerIndex, String name) {
        appendText("[" + name + "][][]");
    }

    @Override
    public void demanderNouveauJoueur() {
        System.out.println(nextPlayerName);
        // on peut ajouter des noms
        btnAddPlayer.setEnabled(true);
        // on peut démarrer une fois que 2 joueurs ont été ajoutés
        btnDealCards.setEnabled(nextPlayerName > 1);
        // mais on ne peut pas demander de trouver un gagnant
        btnFindWinner.setEnabled(false);
    }

    @Override
    public void retournerCartes() {
        // on ne peut plus ajouter de noms
        btnAddPlayer.setEnabled(false);
        // ni distribuer des cartes
        btnDealCards.setEnabled(false);
        // mais on peut demander à trouver un gagnant
        btnFindWinner.setEnabled(true);
    }

    @Override
    public void proposerNouvellePartie() {
        // on ne peut plus ajouter de noms
        btnAddPlayer.setEnabled(false);
        // on peut distribuer des cartes pour la prochaine partie
        btnDealCards.setEnabled(true);
        // on ne peut pas encore trouver un gagnant
        btnFindWinner.setEnabled(false);
    }
}

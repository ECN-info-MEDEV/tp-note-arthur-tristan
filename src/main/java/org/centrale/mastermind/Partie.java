package org.centrale.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe de gestion d'une partie de Mastermind
 * 
 * @author Arthur et Tristan
 */
public class Partie {

    private Code codeATrouver; //le code créé par le codeur
    private int nombreTDJ; //Le nombre de tour de jeu
    private Joueur j1; //Premier joueur
    private Joueur j2; //Second joueur
    Scanner sc;

    /**
     * Constructeur par défaut, toute les variables prennent leur valeur par défaut
     */
    public Partie(Scanner sc){
        this.sc = sc;
        codeATrouver = null;
        nombreTDJ = 0;
        j1 = null;
        j2 = null;
    }

    /**
     * Constructeur classsique d'une partie
     * 
     * @param codeAtrouver
     * @param nbT
     * @param j1
     * @param j2
     */
    public Partie(Code codeAtrouver, int nbT, Joueur j1, Joueur j2, Scanner sc){
        this.codeATrouver = codeAtrouver;
        this.sc = sc;
        this.nombreTDJ = nbT;
        this.j1 = j1;
        this.j2 = j2;
    }

    /**
     * Cette fonction sert au lancement d'une partie de Mastermind, elle s'occupe aussi de gérer les tours de jeu et les rôles entre
     * les joueurs.
     * À chaque tour de jeu, elle demande au codeur de créé un code
     */
    public void launch(){
        if (nombreTDJ > 0){
            Joueur codeur;
            Joueur decodeur;

            if (nombreTDJ%2 == 0){
                codeur = j1;
                decodeur = j2;
            }
            else {
                codeur = j2;
                decodeur = j1;
            }
            System.out.println("Au tour de " + codeur.getPseudo() + ", c'est le codeur : il doit choisir un code que le décodeur va essayer de trouver");
            codeATrouver = new Code(this.sc);
            System.out.println("-------     ------------------------------------------------------------");
            System.out.println("-------------     ------------------------------------------------------");
            System.out.println("---------------------     ----------------------------------------------");
            System.out.println("------------------------------     -------------------------------------");
            System.out.println("----------------------------------------     ---------------------------");
            System.out.println("-------------------------------------------------     ------------------");
            System.out.println("----------------------------------------------------------     ---------");
            System.out.println("------------------------------------------------------------------     -");
            tourDeJeu(codeur, decodeur);
        }
        else{
            System.out.println("Fin du jeu, voici les scores :");
            System.out.println(j1.getPseudo() + " : " + j1.getScore() + " points");
            System.out.println(j2.getPseudo() + " : " + j2.getScore() + " points");
        }
    }

    /**
     * Cette fonction sert à la gestion des tours de jeu du décodeur, le code est déjà généré.
     * Elle gère aussi la fin du tour de décodage et comptabilise les points avant de relancer launch() pour continuer le jeu
     * 
     * @param codeur
     * @param decodeur
     */
    public void tourDeJeu(Joueur codeur,Joueur decodeur){
        int nbEssai = 12;

        while (nbEssai>0){
            if (!decodeur.essai(codeATrouver, sc)){
                System.out.println("-------------------  Essais précédents   -----------------------------");
                for (Code x : decodeur.getCodeEssais()){                   
                    x.affiche();
                }
            }
            else{
                System.out.println("Bravo tu as trouvé !");
                break;
            }
            nbEssai--;      
        }
        if (nbEssai == 0){
            System.out.println("C'est perdu!");
        }

        System.out.println("Le codeur marque " + decodeur.getCodeEssais().size() + " points");
        codeur.setScore(codeur.getScore() + decodeur.getCodeEssais().size());
        decodeur.setCodeEssais(new ArrayList<Code>());
        nombreTDJ--;
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        launch();
    }


    /**
     * Renvoie le code créé par le codeur
     * @return
     */
    public Code getCodeATrouver() {
        return codeATrouver;
    }

    /**
     * Renvoie le nombre de tour de jeu
     * @return
     */
    public int getNombreTDJ() {
        return nombreTDJ;
    }

    /**
     * Renvoie le premier joueur
     * @return
     */
    public Joueur getJ1() {
        return j1;
    }

    /**
     * Renvoie le second joueur
     * @return
     */
    public Joueur getJ2() {
        return j2;
    }

    /**
     * Modifie le code du codeur
     */
    public void setCodeATrouver(Code codeATrouver) {
        this.codeATrouver = codeATrouver;
    }

    /**
     * Modifie le nombre de tour de jeu
     */
    public void setNombreTDJ(int nombreTDJ) {
        this.nombreTDJ = nombreTDJ;
    }

    /**
     * Modifie le premier joueur
     */
    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    /**
     * Modifie le second joueur
     */
    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

}
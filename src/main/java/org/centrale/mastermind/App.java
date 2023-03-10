package org.centrale.mastermind;

import java.util.Scanner;

/**
 * La classe App est la classe principale, elle contient la fonction main.
 * Cette classe sert seulement à l'initialisation d'une partie de jeu
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Bonjour et bienvenu sur cette version du MASTERMIND !");
        System.out.println("Ce jeu se joue à deux joueurs, quelles sont vos pseudos ?"); 
        Scanner sc = new Scanner(System.in);

        String pseudo1 = sc.nextLine();
        String pseudo2 = sc.nextLine();

        Joueur j1 = new Joueur(pseudo1);
        Joueur j2 = new Joueur(pseudo2);

        System.out.println("Veuillez pour commencer choisir le nombre de tours de jeu,"
        + "afin d'être équitable il faut qu'il soit pair"); 

        boolean choix = true;
        int nbT = 0;

        while (choix){
            String c = sc.nextLine();
            try{
                nbT = Integer.parseInt(c);
                if (nbT%2 == 0){
                    choix = false;
                }
                else{
                    System.out.println("Ce choix n'est pas valide");
                }
            } catch (Exception e){
                System.out.println("Ce choix n'est pas valide");
            }
        }

        Partie p = new Partie(null,nbT,j1,j2, sc);
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------Début de la Partie------------------");
        p.launch();

        sc.close();
    }
}

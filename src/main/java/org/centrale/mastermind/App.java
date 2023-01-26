package org.centrale.mastermind;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Bonjour et bienvenu sur cette version du MASTERMIND !");
        System.out.println("Ce jeu se joue à deux joueurs, quelles sont vos pseudos ?"); 
        Scanner clavier = new Scanner(System.in);

        String pseudo1 = clavier.nextLine();
        String pseudo2 = clavier.nextLine();

        Joueur j1 = new Joueur(pseudo1);
        Joueur j2 = new Joueur(pseudo2);

        System.out.println("Veuillez pour commencer choisir le nombre de tours de jeu,"
        + "afin d'être équitable il faut qu'il soit pair"); 

        boolean choix = true;
        int nbT = 0;

        while (choix){
            String c = clavier.nextLine();
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

        Partie p = new Partie(null,nbT,j1,j2);
        p.launch();

        clavier.close();
    }
}

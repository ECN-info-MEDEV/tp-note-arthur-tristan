package org.centrale.mastermind;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * La classe App est la classe principale, elle contient la fonction main.
 * Cette classe sert seulement à l'initialisation d'une partie de jeu
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {

        LOGGER.info("Bonjour et bienvenu sur cette version du MASTERMIND !");
        LOGGER.info("Ce jeu se joue à deux joueurs, quelles sont vos pseudos ?"); 
        Scanner sc = new Scanner(System.in);

        String pseudo1 = sc.nextLine();
        String pseudo2 = sc.nextLine();

        Joueur j1 = new Joueur(pseudo1);
        Joueur j2 = new Joueur(pseudo2);

        LOGGER.info("Veuillez pour commencer choisir le nombre de tours de jeu,"
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
                    LOGGER.info("Ce choix n'est pas valide");
                }
            } catch (Exception e){
                LOGGER.info("Ce choix n'est pas valide");
            }
        }

        Partie p = new Partie(null,nbT,j1,j2, sc);
        LOGGER.info("");
        LOGGER.info("------------------------------------------------------");
        LOGGER.info("------------------Début de la Partie------------------");
        p.launch();

        sc.close();
    }
}

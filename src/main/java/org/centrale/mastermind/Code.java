package org.centrale.mastermind;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Code {
    List<Pion> code;

    public Code() {
        choixCode();
    }

    private void choixCode() {
        System.out.println("Merci de saisir un code.");
        System.out
                .println("Il est constitué d'une chaine de 4 caractères ou chaque caractère correspond à une couleur");
        System.out.println("R=rouge, V = vert, J = jaune, B = bleu, N = noir, W = blanc");
        System.out.println("Exemple de chaine de caractère valide : VJWB");
        Scanner sc = new Scanner(System.in);
        while (code == null) {
            try {
                System.out.println("Merci de saisir une chaine de caractère valide :");
                String s = sc.nextLine();
                this.code = verifValidString(s.toUpperCase());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    private List<Pion> verifValidString(String s) throws Exception {
        List<Pion> listPion = new LinkedList<>();
        if (s.length() != 4) {
            throw new Exception("Le nombre de pion donné n'est pas cohérent !");
        }
        for (int k = 0; k < 4; k++) {
            Pion p;
            char codeCouleur = s.charAt(k);
            switch (codeCouleur) {
                case 'R':
                    p = new Pion("Rouge", codeCouleur);
                    break;
                case 'V':
                    p = new Pion("Vert", codeCouleur);
                    break;
                case 'J':
                    p = new Pion("Jaune", codeCouleur);
                    break;
                case 'B':
                    p = new Pion("Bleu", codeCouleur);
                    break;
                case 'N':
                    p = new Pion("Noir", codeCouleur);
                    break;
                case 'W':
                    p = new Pion("Blanc", codeCouleur);
                    break;
                default:
                    throw new Exception("La couleur : '" + codeCouleur + "' n'est pas valide !");
            }
            listPion.add(p);
        }
        return listPion;
    }

    public void affiche() {
        for (Pion p : code) {
            p.affiche();
            System.out.print(" - ");
        }
    }
}

package org.centrale.mastermind;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe 
 */
public class Code {
    private List<Pion> code;
    private String codeString;
    private String verif;

    public Code() {
        verif = "";
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
                this.codeString = s.toUpperCase();
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

    public void verification(Code codeAVerif) {
        verif = "";
        int nbPionsBienPlaces = 0;
        int nbPionsMalPlaces = 0;
        String codeStringVerif = codeAVerif.getCodeString();
        char c;
        for (int k = 0; k < 4; k++) {
            c = this.codeString.charAt(k);
            if (c == codeStringVerif.charAt(k)) {
                nbPionsBienPlaces++;
            } else if (codeStringVerif.contains("" + c)) {
                nbPionsMalPlaces++;
            }
        }
        for (int k = 0; k < nbPionsBienPlaces; k++) {
            verif += "O ";
        }
        for (int k = 0; k < nbPionsMalPlaces; k++) {
            verif += "~ ";
        }
    }

    public void affiche() {
        for (Pion p : code) {
            p.affiche();
            System.out.print(" - ");
        }
        System.out.println(verif);
    }

    /**
     * @return List<Pion> return the code
     */
    public List<Pion> getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(List<Pion> code) {
        this.code = code;
    }

    /**
     * @return String return the codeString
     */
    public String getCodeString() {
        return codeString;
    }

    /**
     * @param codeString the codeString to set
     */
    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    /**
     * @return String return the verif
     */
    public String getVerif() {
        return verif;
    }

    /**
     * @param verif the verif to set
     */
    public void setVerif(String verif) {
        this.verif = verif;
    }

}

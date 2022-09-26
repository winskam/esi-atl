package model;

/**
 *
 * @author Marika Winska 55047
 */
public class Etudiant {

    private int num;
    private String prenom;
    private String nom;

    public Etudiant(int num, String prenom, String nom) throws Exception {
        if (prenom.length() == 0 || nom.length() == 0) {
            throw new Exception();
        }
        this.num = num;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

}

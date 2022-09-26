package g55047.ex2;

/**
 *
 * @author Marika Winska 55047
 */
public class Compte {

    private int somme;

    public Compte(int somme) {
        this.somme = somme;
    }

    public synchronized int getSomme() {
        return somme;
    }

    public synchronized void deposerArgent(int somme) {
        this.somme += somme;
    }

    public synchronized void retirerArgent(int somme) {
        if (this.somme >= somme) {
            this.somme -= somme;
        }
    }

}

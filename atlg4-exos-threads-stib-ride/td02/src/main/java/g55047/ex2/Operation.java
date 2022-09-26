package g55047.ex2;

/**
 *
 * @author Marika Winska 55047
 */
public class Operation extends Thread {

    private final Compte compte;
    private final int somme;

    public Operation(Compte compte, int somme) {
        super();
        this.compte = compte;
        this.somme = somme;
    }

    @Override
    public void run() {
        while (true) {
            compte.deposerArgent(somme);
            compte.retirerArgent(somme);
            //if (compte.getSomme() < 0) {
                System.out.println(compte.getSomme());
            //}
        }

    }

}

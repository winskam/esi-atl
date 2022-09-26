package g55047.ex2;

/**
 *
 * @author Marika Winska 55047
 */
public class Main {

    public static void main(String[] args) {
        Compte compte = new Compte(20);

        for (int i = 0; i < 20; i++) {
            Operation operation = new Operation(compte, 20);
            operation.start();
        }
    }
}

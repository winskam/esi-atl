package g55047.ex1;

/**
 *
 * @author Marika Winska 55047
 */
import java.util.Random;

/**
 * Classe pourvue d'une methode d'affichage avec des blocs synchronized sur
 * l'objet lui-meme ou sur une chaine de caracteres.
 */
public class MyObject {

    private Random rnd;

    public MyObject() {
        rnd = new Random();
    }

    public void fct() {
        String nom = Thread.currentThread().getName();
        System.out.println("MyObject: " + nom + " in fct");

        System.out.println("MyObject: " + nom + " between bloc 1 and bloc 2");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

    }
}


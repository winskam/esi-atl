package g55047.ex1;

/**
 *
 * @author Marika Winska 55047
 */
public class Test {
    public static void main(String[] args) {

        MyObject mo = new MyObject();
        MyObject mo2 = new MyObject();
        MyThread t1 = new MyThread("t1", mo, mo2);
        MyThread t2 = new MyThread("t2", mo2, mo);
        
        t1.start();
        t2.start();
    }
}

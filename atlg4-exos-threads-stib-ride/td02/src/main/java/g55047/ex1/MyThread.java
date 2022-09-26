package g55047.ex1;

/**
 * Thread utilisant une methode d'une instace de MyObject.
 */
public class MyThread extends Thread {

    private MyObject myObject;
    private MyObject myObject2;

    public MyThread(String name, MyObject myObject, MyObject myObject2) {
        super(name);
        this.myObject = myObject;
        this.myObject2 = myObject2;
    }

    public void run() {
        String nom = Thread.currentThread().getName();
        System.out.println("MyThread: " + nom + " in run");
        synchronized (myObject) {
            myObject.fct();
            synchronized (myObject2) {
                myObject2.fct();
            }
        }

        System.out.println("MyThread: " + nom + " out run");
    }
}

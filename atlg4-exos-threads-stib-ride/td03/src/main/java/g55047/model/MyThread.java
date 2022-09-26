package g55047.model;

import g55047.designpattern.Observable;
import g55047.designpattern.Observer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a thread that will sort an array.
 * 
 * @author Marika Winska 55047
 */
public class MyThread extends Thread implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private final String nameSort;
    private final int[] tab;
    private long duration;
    private long nbOperations;

    /**
     * Constructor of the class.
     * 
     * @param observers
     * @param nameSort name of the sort used.
     * @param tab to sort.
     */
    public MyThread(Observer observers, String nameSort, int[] tab) {
        super(nameSort);
        this.observers.add(observers);
        this.nameSort = nameSort;
        this.tab = tab;
    }

    /**
     * Getter for the name of the sort.
     * 
     * @return
     */
    public String getNameSort() {
        return nameSort;
    }

    /**
     * Getter for the size of the array to sort.
     * 
     * @return the size.
     */
    public int getTabSize() {
        return tab.length;
    }

    /**
     * Getter for the number of operations.
     * 
     * @return the number of operations.
     */
    public long getNbOperations() {
        return nbOperations;
    }

    /**
     * Getter for the duration of a sort.
     * 
     * @return the duration.
     */
    public long getDuration() {
        return duration;
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        observers.forEach((observer) -> {
            observer.update(this, arg);
        });
    }

    @Override
    public void run() {
        LocalDateTime begin = LocalDateTime.now();
        switch (nameSort) {
            case "Bubble sort":
                BubbleSort bubbleSort = new BubbleSort(tab);
                bubbleSort.optimizedBubbleSort();
                this.nbOperations = bubbleSort.getNbOperations();
                break;
            case "Merge sort":
                MergeSort mergeSort = new MergeSort(tab);
                mergeSort.mergeSort(tab, tab.length);
                this.nbOperations = mergeSort.getNbOperations();
        }
        LocalDateTime end = LocalDateTime.now();
        this.duration = Duration.between(begin, end).toMillis();
        notifyObservers();
    }

}

package exercice.model;

import exercice.designpattern.Observable;
import exercice.designpattern.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that will perform the computations on the data inputed by the user.
 *
 * @author Marika Winska 55047
 */
public class Model implements Observable {

    private final List<Observer> observers;
    private double BMR;
    private double calories;
    private double height;
    private double weight;
    private boolean isFemale;

    /**
     * Constructor of the class Model.
     */
    public Model() {
        this.observers = new ArrayList<>();
    }

    /**
     * Getter for BMR.
     *
     * @return
     */
    public double getBMR() {
        return BMR;
    }

    /**
     * Getter for calories.
     *
     * @return
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Getter for height.
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * Getter for weight.
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Getter for isFemale.
     *
     * @return
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Computes the BMR with the given arguments.
     *
     * @param height given by the user.
     * @param weight given by the user.
     * @param age given by the user.
     * @param isFemale selected by the user.
     * @param lifeStyle selected by the user.
     */
    public void calculBMR(double height, double weight, int age, boolean isFemale,
            Lifestyle lifeStyle) {
        this.height = height;
        this.weight = weight;
        this.isFemale = isFemale;
        if (isFemale) {
            this.BMR = 9.6 * weight + 1.8 * height - 4.7 * age + 655;
        } else {
            this.BMR = 13.7 * weight + 5 * height - 6.8 * age + 66;
        }
        calories = calculCalories(this.BMR, lifeStyle);
        notifyObservers();
    }

    /**
     * Computes the calories for BMR with a certain lifestyle.
     *
     * @param BMR computed.
     * @param lifeStyle chosen.
     * @return
     */
    public double calculCalories(double BMR, Lifestyle lifeStyle) {
        return BMR * lifeStyle.getActivity();
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

}

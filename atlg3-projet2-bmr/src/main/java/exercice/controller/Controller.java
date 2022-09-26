package exercice.controller;

import exercice.model.Lifestyle;
import exercice.model.Model;
import exercice.view.VBoxField;

/**
 * Controls the scene display.
 *
 * @author Marika Winska 55047
 */
public class Controller {

    private final Model model;
    private final VBoxField view;

    /**
     * Constructor of the class Controller.
     *
     * @param model represents the model.
     * @param view represents the view.
     */
    public Controller(Model model, VBoxField view) {
        if (model == null || view == null) {
            throw new IllegalArgumentException("Null argument");
        }
        this.model = model;
        this.view = view;
    }

    /**
     * Checks if the arguments are valid. If they are, the model will calculate
     * the BMR, otherwise it will display a alert.
     *
     * @param heightText the height that was provided by the user.
     * @param weightText the weight that was provided by the user.
     * @param ageText the age that was provided by the user.
     * @param isMale if the male's case was selected by the user.
     * @param isFemale if the female's case was selected by the user.
     * @param lifeStyle selected by the user.
     */
    public void compute(String heightText, String weightText, String ageText,
            boolean isMale, boolean isFemale, Lifestyle lifeStyle) {
        try {
            int height = Integer.parseInt(heightText);
            int weight = Integer.parseInt(weightText);
            int age = Integer.parseInt(ageText);

            if (height <= 0 || weight <= 0 || age <= 0
                    || (isMale == false && isFemale == false)
                    || lifeStyle == null) {
                view.alert();
            } else {
                model.calculBMR(height, weight, age, isMale, lifeStyle);
            }

        } catch (NumberFormatException e) {
            view.alert();
        }
    }

}

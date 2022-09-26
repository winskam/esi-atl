package exercice.model;

/**
 * Enumeration of possible lifestyles of the user.
 *
 * @author Marika Winska 55047
 */
public enum Lifestyle {
    SEDENTAIRE(1.2),
    PEU_ACTIF(1.375),
    ACTIF(1.55),
    FORT_ACTIF(1.725),
    EXTREMENT_ACTIF(1.9);

    private final double activity;

    /**
     * Constructor of the class Lifestyle.
     *
     * @param activity the activity.
     */
    private Lifestyle(double activity) {
        this.activity = activity;
    }

    /**
     * Getter for activity.
     *
     * @return activity.
     */
    public double getActivity() {
        return activity;
    }

}

package exercice.view;

import exercice.designpattern.Observable;
import exercice.designpattern.Observer;
import exercice.model.Model;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * A TabPane with multiples line charts.
 *
 * @author Marika Winska 55047
 */
public class MyLineCharts extends TabPane implements Observer {

    private final MyLineChart WeightVsBMR;
    private final MyLineChart WeightVsCalories;
    private final MyLineChart HeightVsBMR;

    /**
     * Constructor of a TabPane with multiples line charts.
     */
    public MyLineCharts() {
        super();

        WeightVsBMR = new MyLineChart();
        WeightVsCalories = new MyLineChart();
        HeightVsBMR = new MyLineChart();

        WeightVsBMR.setNameLineChart("Weight(kg)", "BMR");
        WeightVsCalories.setNameLineChart("Weight(kg)", "Calories");
        HeightVsBMR.setNameLineChart("Height(cm)", "BMR");

        Tab tab1 = new Tab(WeightVsBMR.getTitle());
        Tab tab2 = new Tab(WeightVsCalories.getTitle());
        Tab tab3 = new Tab(HeightVsBMR.getTitle());

        tab1.setContent(WeightVsBMR);
        tab2.setContent(WeightVsCalories);
        tab3.setContent(HeightVsBMR);

        this.getTabs().addAll(tab1, tab2, tab3);
    }

    @Override
    public void update(Observable observable, Object arg) {
        Model model = (Model) observable;
        WeightVsBMR.addToLineChart(model.getIsFemale(),
                model.getWeight(), model.getBMR());
        WeightVsCalories.addToLineChart(model.getIsFemale(),
                model.getWeight(), model.getCalories());
        HeightVsBMR.addToLineChart(model.getIsFemale(),
                model.getHeight(), model.getBMR());
    }

}

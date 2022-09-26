package exercice.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 * Class that will display the line chart.
 *
 * @author Marika Winska 55047
 */
public class MyLineChart extends Pane {

    private final NumberAxis xAxis;
    private final NumberAxis yAxis;
    private final LineChart<Number, Number> lineChart;
    private final XYChart.Series seriesFemale;
    private final XYChart.Series seriesMale;

    /**
     * Constructor of the line chart.
     */
    public MyLineChart() {
        super();
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        seriesFemale = new XYChart.Series();
        seriesMale = new XYChart.Series();
        seriesFemale.setName("Female");
        seriesMale.setName("Male");
        lineChart.getData().add(seriesFemale);
        lineChart.getData().add(seriesMale);
        this.getChildren().add(lineChart);
    }

    /**
     * Setter for the name of the line chart and the axis.
     *
     * @param nameXAxis of the line chart.
     * @param nameYAxis of the line chart.
     */
    public void setNameLineChart(String nameXAxis, String nameYAxis) {
        String nameLineChart = nameXAxis + " vs " + nameYAxis;
        xAxis.setLabel(nameXAxis);
        yAxis.setLabel(nameYAxis);
        lineChart.setTitle(nameLineChart);
    }

    /**
     * Adds data in the line chart.
     *
     * @param isFemale boolean to check if the data has to be added to female or
     * male.
     * @param x value of the data to add.
     * @param y value of the data to add.
     */
    public void addToLineChart(boolean isFemale, double x, double y) {
        if (isFemale) {
            seriesFemale.getData().add(new XYChart.Data<>(x, y));
        } else {
            seriesMale.getData().add(new XYChart.Data<>(x, y));
        }
    }

    /**
     * Getter for the title of the line chart.
     *
     * @return the title.
     */
    public String getTitle() {
        return lineChart.getTitle();
    }

}

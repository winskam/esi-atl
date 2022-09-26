package exercice.view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The view with all the components of BMR.
 *
 * @author Marika Winska 55047
 */
public class GeneralView extends VBox {

    private final VBoxField dataField;
    private final MyLineCharts lineChartField;

    /**
     * Constructor for the general view of the scene.
     *
     * @param dataField the field where the user will have to write his data and
     * his BMR and calories will be shown.
     * @param lineChartField the line charts where the BMR and calories will be
     * displayed.
     */
    public GeneralView(VBoxField dataField, MyLineCharts lineChartField) {
        super();
        if (dataField == null || lineChartField == null) {
            throw new IllegalArgumentException("Null argument");
        }
        this.dataField = dataField;
        this.lineChartField = lineChartField;
        HBox hbox = new HBox(dataField, lineChartField);
        MyMenuBar menubar = new MyMenuBar();
        this.getChildren().addAll(menubar, hbox);
    }

}

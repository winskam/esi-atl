package g55047.view;

import g55047.designpattern.Observable;
import g55047.designpattern.Observer;
import g55047.model.MyThread;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Marika Winska 55047
 */
public class FxmlController implements Initializable, Observer {

    @FXML
    private TableView table;

    @FXML
    private TableColumn nameCol;

    @FXML
    private TableColumn sizeCol;

    @FXML
    private TableColumn swapCol;

    @FXML
    private TableColumn durationCol;

    @FXML
    private LineChart chart;

    @FXML
    private Spinner<Integer> threadSpinner;

    @FXML
    private ChoiceBox<String> sortChoice;

    @FXML
    private ChoiceBox<String> configurationChoice;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label leftStatus;

    private XYChart.Series xySeries = new XYChart.Series();
    
    private double barProgress;

    public FxmlController() {}

    /**
     * Handles the button that starts a sort.
     * 
     * @param event click.
     */
    @FXML
    public void handleButton(ActionEvent event) {
        System.out.println(threadSpinner.getValue());
        int nbConfigurations;
        int nbThreads = threadSpinner.getValue();
        xySeries = new XYChart.Series();
        barProgress = 0;
        switch (configurationChoice.getValue()) {
            case "Very easy : 0-100 / 10":
                nbConfigurations = 100;
                break;
            case "Easy : 0-1.000 / 100":
                nbConfigurations = 1000;
                break;
            case "Moderate : 0-10.000 / 1.000":
                nbConfigurations = 10000;
                break;
            default:
                nbConfigurations = 100000;
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(nbThreads);

        for (int i = 0; i <= nbConfigurations; i += nbConfigurations / 10) {
            int[] tab = new int[i];
            Random random = new Random();
            for (int j = 0; j < tab.length; j++) {
                tab[j] = random.nextInt();
            }
            threadPool.submit(new MyThread(this, sortChoice.getValue(), tab));
        }
        threadPool.shutdown();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sortChoice.setItems(FXCollections.observableArrayList("Bubble sort", "Merge sort"));
        sortChoice.getSelectionModel().selectFirst();

        configurationChoice.setItems(FXCollections.observableArrayList("Very easy : 0-100 / 10",
                "Easy : 0-1.000 / 100", "Moderate : 0-10.000 / 1.000", "Hard : 0-100.000 / 10.000"));
        configurationChoice.getSelectionModel().selectFirst();

        threadSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));

        leftStatus.setText("Nombre de threads actifs : " + Thread.activeCount());

        nameCol.setCellValueFactory(new PropertyValueFactory("nameSort"));
        durationCol.setCellValueFactory(new PropertyValueFactory("duration"));
        sizeCol.setCellValueFactory(new PropertyValueFactory("tabSize"));
        swapCol.setCellValueFactory(new PropertyValueFactory("nbOperations"));
    }

    @Override
    public void update(Observable observable, Object arg) {
        MyThread thread = (MyThread) observable;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    table.getItems().add(observable);
                    xySeries.getData().add(new XYChart.Data(thread.getTabSize(), thread.getNbOperations()));
                    leftStatus.setText("Nombre de threads actifs : " + Thread.activeCount());
                    if (!chart.getData().contains(xySeries)) {
                        chart.getData().add(xySeries);
                    }
                    barProgress += 0.1;
                    progressBar.setProgress(barProgress);
                });
            }
        }).start();
    }

}

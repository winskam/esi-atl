package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Etudiant;

/**
 *
 * @author Marika Winska 55047
 */
public class MyTableView extends TableView {
    
    public MyTableView() throws Exception {
        super();
        TableColumn<Etudiant,Integer> numCol = new TableColumn<>("Numéro");
        TableColumn<Etudiant,String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<Etudiant,String> nomCol = new TableColumn<>("Nom");
        
        this.getColumns().setAll(numCol,prenomCol,nomCol);
        
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        Etudiant std1 = new Etudiant(1, "Arthur", "Paquot");
        Etudiant std2 = new Etudiant(2, "Israe", "Serokh");
        this.getItems().add(std1);
        this.getItems().add(std2);

    }
    
}

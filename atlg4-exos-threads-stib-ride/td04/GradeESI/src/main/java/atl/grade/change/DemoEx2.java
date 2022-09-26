package atl.grade.change;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mar-w
 */
public class DemoEx2 extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            // 1
            String query = "INSERT INTO LESSONS(acronym) values('ANLL')";

            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);

            // 2
            query = "SELECT acronym FROM LESSONS";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String acronym = result.getString("acronym");
                System.out.println("\t record : " + acronym);
            }

            // 3
            query = "DELETE FROM LESSONS WHERE acronym ='ANLL'";

            count = stmt.executeUpdate(query);

            // 4
            query = "SELECT acronym FROM LESSONS";

            result = stmt.executeQuery(query);

            while (result.next()) {
                String acronym = result.getString("acronym");
                System.out.println("\t record : " + acronym);
            }

        } catch (SQLException ex) {
            System.out.println("DEMO_INSERT | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "Insertion d'un utilisateur dans la DB";
    }

}

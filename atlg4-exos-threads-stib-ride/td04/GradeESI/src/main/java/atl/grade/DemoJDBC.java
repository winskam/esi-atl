package atl.grade;

import atl.grade.change.DemoEx2;
import atl.grade.config.ConfigManager;
import atl.grade.date.DemoDateSelect;
import atl.grade.date.DemoEx3;
import atl.grade.injection.DemoInjection;
import atl.grade.join.DemoJoin;
import atl.grade.selection.DemoSelect;
import atl.grade.selection.DemoSelectAll;
import atl.grade.selection.DemoSelectLessons;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jlc
 */
public class DemoJDBC {

    /**
     * Entry points to the <code> Mentoring </code> application.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        try {
            ConfigManager.getInstance().load();
            String dbUrl = ConfigManager.getInstance().getProperties("db.url");
            System.out.println("Base de données stockée : " + dbUrl);

            Demo demo = new DemoJoin();
            demo.printTitle();
            demo.execute(dbUrl);
        } catch (IOException ex) {
            System.out.println("Erreur IO " + ex.getMessage());
        }
    }

    private DemoJDBC() {

    }
}

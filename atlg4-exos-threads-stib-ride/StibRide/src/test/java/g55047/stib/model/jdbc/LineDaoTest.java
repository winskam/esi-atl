package g55047.stib.model.jdbc;

import g55047.stib.model.config.ConfigManager;
import g55047.stib.model.dto.LineDto;
import g55047.stib.model.exception.RepositoryException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Marika Winska 55047
 */
public class LineDaoTest {

    private LineDao instance;

    public LineDaoTest() {
        System.out.println("==== LineDaoTest Constructor =====");
        try {
            ConfigManager.getInstance().load();
            instance = LineDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connexion à la base de données de test", ex);
        }
    }

    /**
     * Test of select method, of class LineDao.
     */
    @org.junit.jupiter.api.Test
    public void testSelect() throws Exception {
        System.out.println("testSelect");
        int expected = 26;
        int result = instance.select(6).getStations().size();
        assertEquals(expected, result);
    }

    /**
     * Test of select method, of class LineDao with a parameter that does not
     * exist.
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        LineDto result = instance.select(7);
        assertNull(result);
    }

    /**
     * Test of select method, of class LineDao with an incorrect parameter.
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        Integer incorrect = null;
        assertThrows(RepositoryException.class, () -> {
            instance.select(incorrect);
        });
    }

    /**
     * Test of selectAll method, of class LineDao.
     */
    @org.junit.jupiter.api.Test
    public void testSelectAll() throws Exception {
        System.out.println("testSelectAll");
        int expected = 4;
        int result = instance.selectAll().size();
        assertEquals(expected, result);
    }
    
}

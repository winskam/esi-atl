package g55047.stib.model.jdbc;

import g55047.stib.model.config.ConfigManager;
import g55047.stib.model.dto.StationDto;
import g55047.stib.model.exception.RepositoryException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Marika Winska 55047
 */
public class StationDaoTest {

    private StationDao instance;

    public StationDaoTest() {
        System.out.println("==== StationDaoTest Constructor =====");
        try {
            ConfigManager.getInstance().load();
            instance = StationDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connexion à la base de données de test", ex);
        }
    }

    /**
     * Test of select method, of class StationDao.
     */
    @org.junit.jupiter.api.Test
    public void testSelect() throws Exception {
        System.out.println("testSelect");
        StationDto expected = new StationDto("SCHUMAN", null, 8062);
        StationDto result = instance.select(8062);
        assertEquals(expected, result);
    }
    
    /**
     * Test of select method, of class StationDao with a parameter that does not
     * exist.
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        StationDto result = instance.select(70);
        assertNull(result);
    }

    /**
     * Test of select method, of class StationDao with an incorrect parameter.
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
     * Test of selectAll method, of class StationDao.
     */
    @org.junit.jupiter.api.Test
    public void testSelectAll() throws Exception {
        System.out.println("testSelectAll");
        int expected = 60;
        int result = instance.selectAll().size();
        assertEquals(expected, result);
    }
    
}

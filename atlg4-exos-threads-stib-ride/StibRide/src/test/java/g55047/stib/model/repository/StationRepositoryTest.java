package g55047.stib.model.repository;

import g55047.stib.model.dto.StationDto;
import g55047.stib.model.jdbc.StationDao;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Marika Winska 55047
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StationRepositoryTest {

    @Mock
    private StationDao mock;

    public StationRepositoryTest() {
    }

    /**
     * Test of get method, of class StationRepository.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("testGet");
        StationRepository repository = new StationRepository(mock);
        repository.get(8012);
        Mockito.verify(mock, times(1)).select(8012);
    }

    /**
     * Test of get method, of class StationRepository with a parameter that does
     * not exist.
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        StationRepository repository = new StationRepository(mock);
        StationDto result = repository.get(0000);
        assertNull(result);
        Mockito.verify(mock, times(1)).select(0000);
    }

    /**
     * Test of getAll method, of class StationRepository.
     *
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testGetAll() throws Exception {
        System.out.println("testGetAll");
        //int expected = 60;
        StationRepository repository = new StationRepository(mock);
        repository.getAll().size();
        //assertEquals(expected, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    /**
     * Test of contains method, of class StationRepository.
     *
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testContains() throws Exception {
        System.out.println("testContains");
        StationRepository repository = new StationRepository(mock);
        repository.contains(8202);
        Mockito.verify(mock, times(1)).select(8202);
    }

}

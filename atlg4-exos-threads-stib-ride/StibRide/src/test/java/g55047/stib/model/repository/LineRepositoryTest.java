package g55047.stib.model.repository;

import g55047.stib.model.dto.LineDto;
import g55047.stib.model.jdbc.LineDao;
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
public class LineRepositoryTest {

    @Mock
    private LineDao mock;

    public LineRepositoryTest() {
    }

    /**
     * Test of get method, of class LineRepository.
     *
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testGet() throws Exception {
        System.out.println("testGet");
        //int expected = 21;
        LineRepository repository = new LineRepository(mock);
        repository.get(1);
        //assertEquals(expected, result);
        Mockito.verify(mock, times(1)).select(1);
    }

    /**
     * Test of get method, of class LineRepository with a parameter that does
     * not exist.
     *
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        LineRepository repository = new LineRepository(mock);
        LineDto result = repository.get(7);
        assertNull(result);
        Mockito.verify(mock, times(1)).select(7);
    }

    /**
     * Test of getAll method, of class LineRepository.
     *
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testGetAll() throws Exception {
        System.out.println("testGetAll");
        //int expected = 4;
        LineRepository repository = new LineRepository(mock);
        repository.getAll().size();
        //assertEquals(expected, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    /**
     * Test of contains method, of class LineRepository.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testContains() throws Exception {
        System.out.println("testContains");
        LineRepository repository = new LineRepository(mock);
        repository.contains(1);
        Mockito.verify(mock, times(1)).select(1);
    }

//    @org.junit.jupiter.api.Test
//    public void testGetIncorrectParameter() throws Exception {
//        System.out.println("testGetIncorrectParameter");
//        //Arrange
//        LineRepository repository = new LineRepository(mock);
//        Integer incorrect = null;
//        //Assert
//        assertThrows(RepositoryException.class, () -> {
//            //Action
//            repository.get(incorrect);
//        });
//        Mockito.verify(mock, times(1)).select(null);
//    }
    
}

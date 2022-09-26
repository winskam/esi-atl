package atl.grade.jdbc;

import atl.grade.config.ConfigManager;
import atl.grade.dto.GradeDto;
import atl.grade.dto.StudentDto;
import atl.grade.exception.RepositoryException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jlc
 */
public class StudentsDaoTest {

    private static final int KEY = 6;

    private final StudentDto bob;
    private final StudentDto patrick;
    private final StudentDto maggy;

    private final List<StudentDto> all;

    private StudentsDao instance;

    public StudentsDaoTest() {
        System.out.println("==== StudentDaoTest Constructor =====");
        bob = new StudentDto(KEY, "SquarePants", "SpongeBob");
        patrick = new StudentDto(99_999, "Star", "Patrick");

        List<GradeDto> grades = new ArrayList<>();
        grades.add(new GradeDto(14, "ATL", 6));
        grades.add(new GradeDto(16, "ATL", 7));
        grades.add(new GradeDto(10, "ATL", 8));
        maggy = new StudentDto(1, "Olsen", "Maggy");
        maggy.setGrades(grades);
        all = new ArrayList<>();
        all.add(maggy);
        all.add(new StudentDto(2, "Frost", "Phoebe"));
        all.add(new StudentDto(3, "Ortega", "Skyler"));
        all.add(new StudentDto(4, "Blankenship", "Byron"));
        all.add(new StudentDto(5, "Cote", "Molly"));
        all.add(bob);

        try {
            ConfigManager.getInstance().load();
            instance = StudentsDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connection à la base de données de test", ex);
        }
    }

    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        StudentDto expected = bob;
        //Action
        StudentDto result = instance.select(KEY);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        //Action
        StudentDto result = instance.select(patrick.getKey());
        //Assert
        assertNull(result);
    }

    @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        //Arrange
        Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.select(incorrect);
        });
    }

    @Test
    public void testgetFullStudent() throws Exception {
        System.out.println("testgetFullStudent");
        //Arrange
        StudentDto expected = maggy;
        //Action
        StudentDto result = instance.select(1);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testgetFullStudentIncorrectParameter() throws Exception {
        System.out.println("testgetFullStudentIncorrectParameter");
        //Arrange
        Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.getFullStudent(incorrect);
        });
    }
    
    @Test
    public void testgetFullStudentNotExist() throws Exception {
        System.out.println("testgetFullStudentNotExist");
        //Arrange
        //Action
        StudentDto result = instance.getFullStudent(patrick.getKey());
        //Assert
        assertNull(result);
    }
    
}

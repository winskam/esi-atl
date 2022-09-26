package g55047.stib.model.repository;

import g55047.stib.model.dto.LineDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.jdbc.LineDao;
import java.util.List;

/**
 * Repository to manage the LINES in the data base.
 * 
 * @author Marika Winska 55047
 */
public class LineRepository implements Repository<Integer, LineDto> {

    private final LineDao dao;

    /**
     * Constructor of the class.
     * 
     * @throws RepositoryException
     */
    public LineRepository() throws RepositoryException {
        dao = LineDao.getInstance();
    }

    /**
     * Constructor of the class.
     * 
     * @param dao 
     */
    LineRepository(LineDao dao) {
        this.dao = dao;
    }

    @Override
    public LineDto get(Integer key) throws RepositoryException {
        LineDto refreshItem = dao.select(key);
        return refreshItem;
    }
    
    @Override
    public List<LineDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        LineDto refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public Integer add(LineDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

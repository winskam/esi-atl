package g55047.stib.model.repository;

import g55047.stib.model.dto.StationDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.jdbc.StationDao;
import java.util.List;

/**
 * Repository to manage the STATIONS in the data base.
 * 
 * @author Marika Winska 55047
 */
public class StationRepository implements Repository<Integer, StationDto> {

    private final StationDao dao;

    /**
     *  Constructor of the class.
     * 
     * @throws RepositoryException
     */
    public StationRepository() throws RepositoryException {
        dao = StationDao.getInstance();
    }

    /**
     * Constructor of the class.
     * 
     * @param dao 
     */
    StationRepository(StationDao dao) {
        this.dao = dao;
    }

    @Override
    public StationDto get(Integer key) throws RepositoryException {
        StationDto refreshItem = dao.select(key);
        return refreshItem;
    }
    
    @Override
    public List<StationDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        StationDto refreshItem = dao.select(key);
        return refreshItem != null;
    }

    @Override
    public Integer add(StationDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

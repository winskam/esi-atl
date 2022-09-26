package g55047.stib.model.repository;

import g55047.stib.model.dto.FavRouteDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.jdbc.FavRouteDao;
import java.util.List;

/**
 * Repository to manage the FAVROUTES in the data base.
 * 
 * @author Marika Winska 55047
 */
public class FavRouteRepository implements Repository<Integer, FavRouteDto> {

    private final FavRouteDao dao;

    /**
     * Constructor of the class.
     * 
     * @throws RepositoryException
     */
    public FavRouteRepository() throws RepositoryException {
        dao = FavRouteDao.getInstance();
    }

    /**
     * Constructor of the class.
     * 
     * @param dao 
     */
    FavRouteRepository(FavRouteDao dao) {
        this.dao = dao;
    }

    @Override
    public FavRouteDto get(Integer key) throws RepositoryException {
        FavRouteDto refreshItem = dao.select(key);
        return refreshItem;
    }

    @Override
    public List<FavRouteDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }
    
    @Override
    public boolean contains(Integer key) throws RepositoryException {
        FavRouteDto refreshItem = dao.select(key);
        return refreshItem != null;
    }
    
    @Override
    public Integer add(FavRouteDto item) throws RepositoryException {
        if (contains(item.getKey())) {
            dao.update(item);
            return item.getKey();
        } else {
            return dao.insert(item);
        }
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        dao.delete(key);
    }
    
}

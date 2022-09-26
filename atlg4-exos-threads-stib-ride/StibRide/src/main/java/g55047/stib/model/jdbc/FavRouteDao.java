package g55047.stib.model.jdbc;

import g55047.stib.model.dto.FavRouteDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.repository.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class managing the favourites in the data base.
 * 
 * @author Marika Winska 55047
 */
public class FavRouteDao implements Dao<Integer, FavRouteDto> {

    private final Connection connexion;

    private FavRouteDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();
    }

    @Override
    public FavRouteDto select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id, name, origin, destination FROM FAVROUTES"
                + " WHERE id = ?";
        FavRouteDto favRoute = null;
        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                favRoute = new FavRouteDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return favRoute;
    }
    
    @Override
    public List<FavRouteDto> selectAll() throws RepositoryException {
        String sql = "SELECT id, name, origin, destination FROM FAVROUTES";
        List<FavRouteDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FavRouteDto dto = new FavRouteDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    @Override
    public Integer insert(FavRouteDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        Integer id = 0;
        String sql = "INSERT INTO FAVROUTES(name, origin, destination) values(?, ?, ?)";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getOrigin());
            pstmt.setInt(3, item.getDestination());
            pstmt.executeUpdate();

            ResultSet result = pstmt.getGeneratedKeys();
            while (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return id;
    }
    
    @Override
    public void update(FavRouteDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        String sql = "UPDATE FAVROUTES SET name=? , origin=?, destination=? where id=? ";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getOrigin());
            pstmt.setInt(3, item.getDestination());
            pstmt.setInt(4, item.getKey());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "DELETE FROM FAVROUTES WHERE id = ?";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }
    
    public static FavRouteDao getInstance() throws RepositoryException {
        return FavRouteDtoHolder.getInstance();
    }

    private static class FavRouteDtoHolder {
        private static FavRouteDao getInstance() throws RepositoryException {
            return new FavRouteDao();
        }
    }

}

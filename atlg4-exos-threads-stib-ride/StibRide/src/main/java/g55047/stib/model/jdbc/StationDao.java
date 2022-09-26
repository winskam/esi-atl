package g55047.stib.model.jdbc;

import g55047.stib.model.dto.StationDto;
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
 * Class managing the stations in the data base.
 * 
 * @author Marika Winska 55047
 */
public class StationDao implements Dao<Integer, StationDto> {

    private final Connection connexion;

    private StationDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();
    }

    @Override
    public StationDto select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id, name FROM STATIONS"
                + " WHERE id = ?";
        StationDto station = null;
        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<Integer> lines = new ArrayList<>();
                String sql2 = "SELECT id_line FROM STOPS"
                        + " WHERE id_station = ?";
                try (PreparedStatement stmt2 = connexion.prepareStatement(sql2)) {
                    stmt2.setInt(1, key);
                    ResultSet rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        lines.add(rs2.getInt(1));
                    }
                } catch (SQLException e) {
                    throw new RepositoryException(e);
                }
                station = new StationDto(rs.getString(2), lines, rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return station;
    }

    @Override
    public List<StationDto> selectAll() throws RepositoryException {
        String sql = "SELECT id, name FROM STATIONS";
        List<StationDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                List<Integer> lines = new ArrayList<>();
                String sql2 = "SELECT id_line FROM STOPS"
                        + " WHERE id_station = ?";
                try (PreparedStatement stmt2 = connexion.prepareStatement(sql2)) {
                    stmt2.setInt(1, rs.getInt(1));
                    ResultSet rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        lines.add(rs2.getInt(1));
                    }
                } catch (SQLException e) {
                    throw new RepositoryException(e);
                }
                StationDto dto = new StationDto(rs.getString(2), lines, rs.getInt(1));
                dtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }
    
    @Override
    public Integer insert(StationDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(StationDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public void delete(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static StationDao getInstance() throws RepositoryException {
        return StationDtoHolder.getInstance();
    }

    private static class StationDtoHolder {
        private static StationDao getInstance() throws RepositoryException {
            return new StationDao();
        }
    }

}

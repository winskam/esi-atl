package g55047.stib.model.jdbc;

import g55047.stib.model.dto.LineDto;
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
 * Class managing the lines in the data base.
 * 
 * @author Marika Winska 55047
 */
public class LineDao implements Dao<Integer, LineDto> {

    private final Connection connexion;

    private LineDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();
    }

    
    @Override
    public LineDto select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id FROM LINES"
                + " WHERE id = ?";
        LineDto line = null;
        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setInt(1, key);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<StationDto> stations = new ArrayList<>();
                String sql2 = "SELECT id_line, name, id_station FROM STOPS"
                + " JOIN STATIONS on id = id_station"
                + " WHERE id_line = ?"
                + " ORDER BY id_order";
                try (PreparedStatement stmt2 = connexion.prepareStatement(sql2)) {
                    stmt2.setInt(1, key);
                    ResultSet rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        stations.add(new StationDto(rs2.getString(2), null, rs2.getInt(3)));
                    }
                } catch (SQLException e) {
                    throw new RepositoryException(e);
                }
                line = new LineDto(stations, rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return line;
    }
    
    @Override
    public List<LineDto> selectAll() throws RepositoryException {
        String sql = "SELECT id FROM LINES";
        List<LineDto> lines = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                List<StationDto> stations = new ArrayList<>();
                String sql2 = "SELECT id_line, name, id_station FROM STOPS"
                + " JOIN STATIONS on id = id_station"
                + " WHERE id_line = ?"
                + " ORDER BY id_order";
                try (PreparedStatement stmt2 = connexion.prepareStatement(sql2)) {
                    stmt2.setInt(1, rs.getInt(1));
                    ResultSet rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        stations.add(new StationDto(rs2.getString(2), null, rs2.getInt(3)));
                    }
                } catch (SQLException e) {
                    throw new RepositoryException(e);
                }
                lines.add(new LineDto(stations, rs.getInt(1)));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return lines;
    }

    @Override
    public Integer insert(LineDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LineDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static LineDao getInstance() throws RepositoryException {
        return LineDtoHolder.getInstance();
    }

    private static class LineDtoHolder {
        private static LineDao getInstance() throws RepositoryException {
            return new LineDao();
        }
    }
    
}

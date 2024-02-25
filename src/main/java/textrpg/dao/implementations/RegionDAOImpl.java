package textrpg.dao.implementations;

import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.RegionDAO;
import textrpg.models.Region;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegionDAOImpl implements RegionDAO {

    public static final String GET_SCENE_BY_ID_QUERY = "select * from scene where scene_id = ?";

    public Region getById(int region_id) {
        try (Connection conn = SqliteConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(GET_SCENE_BY_ID_QUERY);
            stmt.setInt(1, region_id);

            ResultSet result = stmt.executeQuery();

            String title = result.getString("title");
            String description = result.getString("description");

            return new Region(title, description);
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return null;
    }
}

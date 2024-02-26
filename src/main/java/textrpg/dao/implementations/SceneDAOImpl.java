package textrpg.dao.implementations;

import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.models.Scene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SceneDAOImpl implements SceneDAO {

    public static final String GET_SCENE_BY_ID_QUERY = "select * from scene where scene_id = ?";
    public static final String GET_SCENE_BY_LOCATION_KEY_QUERY = "select * from scene where location_key = ? and region_id = ?";

    @Override
    public Scene getByLocation(int region_id, String location_key) {
        try (Connection conn = SqliteConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(GET_SCENE_BY_LOCATION_KEY_QUERY);
            stmt.setString(1, location_key);
            stmt.setInt(2, region_id);

            ResultSet result = stmt.executeQuery();
            return extractSceneObj(result);
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return null;
    }

    private Scene extractSceneObj(ResultSet queryResult) throws SQLException {
        String title = queryResult.getString("title");
        String description = queryResult.getString("description");
        String locationKey = queryResult.getString("location_key");


        return new Scene(title, description, locationKey);
    }

    public Scene getById(int scene_id) {
        try (Connection conn = SqliteConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(GET_SCENE_BY_ID_QUERY);
            stmt.setInt(1, scene_id);

            ResultSet result = stmt.executeQuery();

            return extractSceneObj(result);
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return null;
    }
}

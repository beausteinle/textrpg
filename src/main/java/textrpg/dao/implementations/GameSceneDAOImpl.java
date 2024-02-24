package textrpg.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.GameSceneDAO;
import textrpg.models.GameScene;

public class GameSceneDAOImpl implements GameSceneDAO {

    public static final String GET_SCENE_BY_ID_QUERY = "select * from scene where scene_id = ?";

    public GameScene getById(int scene_id) {
        try (Connection conn = SqliteConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(GET_SCENE_BY_ID_QUERY);
            stmt.setInt(1, scene_id);

            ResultSet result = stmt.executeQuery();

            String title = result.getString("title");
            String description = result.getString("description");

            return new GameScene(title, description);
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return null;
    }
}

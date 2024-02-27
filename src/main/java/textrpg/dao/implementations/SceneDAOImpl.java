package textrpg.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.models.Scene;
import textrpg.utils.WorldPosition;

public class SceneDAOImpl implements SceneDAO {

  public static final String GET_SCENE_BY_ID_QUERY = "select * from scene where scene_id = ?";
  public static final String GET_SCENE_BY_LOCATION_KEY_QUERY =
      "select * from scene where x_location = ? and y_location = ? and region_id = ?";

  @Override
  public Scene getByLocation(WorldPosition worldPosition) {
    try (Connection conn = SqliteConnection.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(GET_SCENE_BY_LOCATION_KEY_QUERY);
      stmt.setInt(1, worldPosition.getxLocation());
      stmt.setInt(2, worldPosition.getyLocation());
      stmt.setInt(3, worldPosition.getRegionId());

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
    int regionId = queryResult.getInt("region_id");
    int xLocation = queryResult.getInt("x_location");
    int yLocation = queryResult.getInt("y_location");

    return new Scene(title, description, new WorldPosition(regionId, xLocation, yLocation));
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

package textrpg.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.WorldStateDAO;
import textrpg.models.CharacterState;
import textrpg.models.WorldState;
import textrpg.utils.WorldPosition;

public class WorldStateDAOImpl implements WorldStateDAO {
  public static final String GET_WORLD_STATE_BY_ID =
      """
        select
          ws.world_state_id,
          cs.current_region_id as region_id,
          cs.x_location,
          cs.y_location
        from world_state ws
          join character_state cs on ws.character_state_id = cs.character_state_id
        where ws.world_state_id = ?
      """;

  @Override
  public WorldState getWorldStateById(int id) {

    try (Connection conn = SqliteConnection.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(GET_WORLD_STATE_BY_ID);
      stmt.setInt(1, id);

      ResultSet result = stmt.executeQuery();

      int worldStateId = result.getInt("world_state_id");
      int regionId = result.getInt("region_id");
      int xPosition = result.getInt("x_location");
      int yPosition = result.getInt("y_location");

      return new WorldState(
          worldStateId, new CharacterState(new WorldPosition(regionId, xPosition, yPosition)));
    } catch (SQLException err) {
      System.err.println(err.getMessage());
    }
    return null;
  }
}

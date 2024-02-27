package textrpg.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.CharacterStateDAO;
import textrpg.models.CharacterState;
import textrpg.utils.WorldPosition;

public class CharacterStateDAOImpl implements CharacterStateDAO {

  public static final String GET_CHARACTER_STATE_BY_ID =
      "select * from character_state where character_state_id = ?";

  @Override
  public CharacterState getById(int id) {
    try (Connection conn = SqliteConnection.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(GET_CHARACTER_STATE_BY_ID);
      stmt.setInt(1, id);

      ResultSet result = stmt.executeQuery();

      int regionId = result.getInt("region_id");
      int xPosition = result.getInt("x_position");
      int yPosition = result.getInt("y_position");

      return new CharacterState(new WorldPosition(regionId, xPosition, yPosition));
    } catch (SQLException err) {
      System.err.println(err.getMessage());
    }
    return null;
  }
}

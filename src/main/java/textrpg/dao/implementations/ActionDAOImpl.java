package textrpg.dao.implementations;

import java.sql.*;
import java.util.ArrayList;
import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.ActionDAO;
import textrpg.models.Action;
import textrpg.utils.ActionType;

public class ActionDAOImpl implements ActionDAO {

  public static final String GET_ACTION_BY_SCENE_ID_QUERY =
      """
                    SELECT action_type, action.description, action.outcome, action.title
                    FROM action_type
                    JOIN action
                    ON action_type.action_type_id = action.action_type_id
                    JOIN scene_action_link
                    ON action.action_id = scene_action_link.action_id
                    WHERE scene_id = ?;
                    """;

  @Override
  public Action[] getActionBySceneId(int sceneId) {
    try (Connection conn = SqliteConnection.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(GET_ACTION_BY_SCENE_ID_QUERY);
      stmt.setInt(1, sceneId);

      ResultSet result = stmt.executeQuery();
      ArrayList<Action> actions = new ArrayList<>();
      while (result.next()) {
        actions.add(extractAction(result));
      }
      return actions.toArray(new Action[actions.size()]);
    } catch (SQLException err) {
      System.err.println(err.getMessage());
    }
    return null;
  }

  public Action extractAction(ResultSet result) throws SQLException {
    ActionType actionType = ActionType.valueOf(result.getString("action_type"));
    String description = result.getString("description");
    String outcome = result.getString("outcome");
    String title = result.getString("title");

    return new Action(actionType, title, description, outcome);
  }
}

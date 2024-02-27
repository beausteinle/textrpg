package textrpg.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import textrpg.dao.SqliteConnection;
import textrpg.dao.interfaces.RegionDAO;
import textrpg.models.Region;

public class RegionDAOImpl implements RegionDAO {

  public static final String GET_REGION_BY_ID_QUERY = "select * from region where region_id = ?";

  public Region getById(int region_id) {
    try (Connection conn = SqliteConnection.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(GET_REGION_BY_ID_QUERY);
      stmt.setInt(1, region_id);

      ResultSet result = stmt.executeQuery();

      String title = result.getString("title");
      String description = result.getString("description");

      return new Region(region_id, title, description);
    } catch (SQLException err) {
      System.err.println(err.getMessage());
    }
    return null;
  }
}

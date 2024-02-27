package textrpg.dao.interfaces;

import textrpg.models.Scene;
import textrpg.utils.WorldPosition;

public interface SceneDAO {
  public Scene getById(int scene_id);

  public Scene getByLocation(WorldPosition worldPosition);
}

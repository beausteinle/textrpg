package textrpg.dao.interfaces;

import textrpg.models.Action;

public interface ActionDAO {
  public Action[] getActionBySceneId(int sceneId);
}

package textrpg.models;

import textrpg.dao.implementations.ActionDAOImpl;
import textrpg.dao.interfaces.ActionDAO;
import textrpg.utils.WorldPosition;

public class Scene {
  int sceneId;
  String title;
  String description;
  WorldPosition worldPosition;
  Action[] actions;

  public Scene() {
    this(0, "Empty Scene", "", new WorldPosition(0, 0, 0));
  }

  public Scene(int sceneId, String title, String description, WorldPosition worldPosition) {
    this.sceneId = sceneId;
    this.title = title;
    this.description = description;
    this.worldPosition = worldPosition;

    ActionDAO dao = new ActionDAOImpl();
    this.actions = dao.getActionBySceneId(sceneId);
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Action[] getActions() {
    return actions;
  }

  public void setActions(Action[] actions) {
    this.actions = actions;
  }
}

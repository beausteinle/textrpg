package textrpg.models;

import textrpg.utils.WorldPosition;

public class Scene {
  String title;
  String description;
  WorldPosition worldPosition;
  Action[] actions;

  public Scene() {
    this("Empty Scene", "", new WorldPosition(0, 0, 0));
  }

  public Scene(String title, String description, WorldPosition worldPosition) {
    this.title = title;
    this.description = description;
    this.worldPosition = worldPosition;
  }

  public Scene(String title, String description, int regionId, int xLocation, int yLocation) {
    this(title, description, new WorldPosition(regionId, xLocation, yLocation));
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

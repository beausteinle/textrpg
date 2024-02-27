package textrpg.models;

public class Scene {
  String title;
  String description;
  String locationKey;
  Action[] actions;

  public Scene(String title, String description, String locationKey) {
    this.title = title;
    this.description = description;
    this.locationKey = locationKey;
  }

  public Scene() {
    this("Empty Scene", "", "");
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public void setActions(Action[] actions) {
    this.actions = actions;
  }

  public Action[] getActions() {
    return actions;
  }
}

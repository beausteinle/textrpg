package textrpg.models;

public class Scene {
  String title;
  String description;

  Action[] actions;

  public Scene(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public Scene() {
    this("Empty Scene", "");
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

package textrpg.user_interface;

import textrpg.models.Action;
import textrpg.models.Scene;

public interface UserInterface {
  public void displayScene(Scene scene);

  public void displayActions(Action[] actions);

  public Action getUserSelection(Scene scene);
}

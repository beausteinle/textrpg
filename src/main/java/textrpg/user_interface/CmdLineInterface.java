package textrpg.user_interface;

import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.utils.Utils;

public class CmdLineInterface implements UserInterface {

  @Override
  public String displayScene(Scene scene) {
    String title = String.format("~~ %s ~~", scene.getTitle());
    String border = Utils.getBorderString(title);

    return title + "\n" + border + "\n" + scene.getDescription() + "\n";
  }

  @Override
  public String displayActions(Action[] actions) {
    String message = "What would you like to do?";
    String border = Utils.getBorderString(message);
    message += "\n" + border + "\n";

    for (int i = 0; i < actions.length; i++) {
      message += String.format("%d - %s\n", i + 1, actions[i].getActionText());
    }

    return message;
  }
}

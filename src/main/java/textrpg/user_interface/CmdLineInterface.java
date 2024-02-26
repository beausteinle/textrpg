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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayActions'");
  }
}

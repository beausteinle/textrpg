package textrpg.game;

import java.util.Scanner;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.user_interface.CmdLineInterface;
import textrpg.user_interface.UserInterface;

public class SceneController {
  Scanner in;

  Scene currentScene;

  UserInterface cmdInterface = new CmdLineInterface();

  public SceneController() {
    in = new Scanner(System.in);
  }

  public void playScene(Scene scene) {
    cmdInterface.displayScene(scene);
    cmdInterface.displayActions(scene.getActions());

    Action selectedAction = cmdInterface.getUserSelection(scene);

    System.out.println(selectedAction.getResult().getResultDescription());
  }
}

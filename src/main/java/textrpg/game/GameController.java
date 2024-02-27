package textrpg.game;

import textrpg.dao.implementations.SceneDAOImpl;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.models.WorldState;
import textrpg.user_interface.CmdLineInterface;
import textrpg.user_interface.UserInterface;
import textrpg.utils.WorldPosition;

import java.util.Scanner;

public class GameController {
  Scanner in;
  WorldState worldState;


  Scene currentScene;

  UserInterface cmdInterface = new CmdLineInterface();

  public GameController() {
    in = new Scanner(System.in);
  }

  public void playScene(Scene scene) {
    cmdInterface.displayScene(scene);
    cmdInterface.displayActions(scene.getActions());

    Action selectedAction = cmdInterface.getUserSelection(scene);

    System.out.println(selectedAction.getResult().getResultDescription());
  }


  /**
   * Moves the character to the next position in the game world and retrieves the scene
   * at that location.
   *
   * @return The scene at the next position after the character moves.
   */
  public Scene moveCharacter() {
    SceneDAO dao = new SceneDAOImpl();
    WorldPosition current = worldState.getCharacterState().getWorldPosition();
    WorldPosition next = cmdInterface.getNextPosition(current);

    worldState.getCharacterState().setWorldPosition(next);

    return dao.getByLocation(next);
  }
}

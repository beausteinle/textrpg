package textrpg.game;

import java.util.Scanner;
import textrpg.dao.implementations.SceneDAOImpl;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.models.CharacterState;
import textrpg.models.Scene;
import textrpg.models.WorldState;
import textrpg.user_interface.CmdLineInterface;
import textrpg.user_interface.UserInterface;
import textrpg.utils.WorldPosition;

public class GameController {
  Scanner in;
  WorldState worldState;
  SceneDAO sceneDAO = new SceneDAOImpl();

  Scene currentScene;

  UserInterface cmdInterface = new CmdLineInterface();

  public GameController() {
    in = new Scanner(System.in);
  }

  public GameController(WorldState worldState) {
    in = new Scanner(System.in);
    this.worldState = worldState;

    CharacterState characterState = worldState.getCharacterState();
    WorldPosition worldPosition = characterState.getWorldPosition();

    currentScene = sceneDAO.getByLocation(worldPosition);
  }

  public void playScene(Scene scene) {
    cmdInterface.displayScene(scene);
    //    cmdInterface.displayActions(scene.getActions());

    //    Action selectedAction = cmdInterface.getUserSelection(scene);
    //
    //    System.out.println(selectedAction.getResult().getResultDescription());

    currentScene = moveCharacter();
  }

  public void playCurrentScene() {
    playScene(currentScene);
  }

  /**
   * Moves the character to the next position in the game world and retrieves the scene at that
   * location.
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

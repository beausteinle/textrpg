package textrpg.user_interface;

import java.util.Scanner;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.utils.Utils;
import textrpg.utils.WorldPosition;

public class CmdLineInterface implements UserInterface {
  private Scanner in;

  public CmdLineInterface() {
    in = new Scanner(System.in);
  }

  @Override
  public void displayScene(Scene scene) {
    String title = String.format("~~ %s ~~", scene.getTitle());
    String border = Utils.getBorderString(title);

    System.out.println(title + "\n" + border + "\n" + scene.getDescription() + "\n");
  }

  @Override
  public void displayActions(Action[] actions) {
    String message = "What would you like to do?";
    String border = Utils.getBorderString(message);
    message += "\n" + border + "\n";

    for (int i = 0; i < actions.length; i++) {
      message += String.format("%d - %s\n", i + 1, actions[i].getActionText());
    }

    System.out.println(message);
  }

  public Action getUserSelection(Scene scene) {
    Action[] actions = scene.getActions();

    System.out.print("What are you going to do: ");
    int selection = in.nextInt();

    return actions[selection - 1];
  }

  public WorldPosition getNextPosition(WorldPosition currentPosition) {
    WorldPosition nextPosition = new WorldPosition(currentPosition);
    System.out.println("Enter the direction you wish to travel! (n, e, s, w): ");
    String direction = in.next();
    direction = direction.toLowerCase();
    if (direction.startsWith("n")) {
      nextPosition.setyLocation(nextPosition.getyLocation() + 1);
    } else if (direction.startsWith("e")) {
        nextPosition.setxLocation(nextPosition.getxLocation() + 1);
    } else if (direction.startsWith("s")) {
      nextPosition.setyLocation(nextPosition.getyLocation() - 1);
    } else if (direction.startsWith("w")) {
      nextPosition.setxLocation(nextPosition.getxLocation() - 1);
    } else {
      //TODO Error handling
    }
    return nextPosition;
  }
}

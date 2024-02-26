package textrpg.user_interface;

import java.util.Scanner;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.utils.Utils;

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
}

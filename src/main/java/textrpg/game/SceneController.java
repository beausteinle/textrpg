package textrpg.game;

import java.util.Arrays;
import java.util.Scanner;

import textrpg.utils.Utils;

public class SceneController {
    Scanner in;

    GameScene currentScene;

    public SceneController() {
        in = new Scanner(System.in);
    }

    public void playScene(GameScene scene) {
        String title = String.format("~~ %s ~~", scene.getTitle());
        String border = Utils.getBorderString(title);

        System.out.println(title);
        System.out.println(border);
        System.out.println(scene.getDescription());
        System.out.println();

        displayOptions(scene.getActions());

        System.out.println(getSelection(scene.getActions()).getResult().getOutcome());
    }

    public void displayOptions(Option[] actions) {
        String message = "What would you like to do?";
        System.out.println(message);
        System.out.println(Utils.getBorderString(message));
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d - %s\n", i + 1, actions[i].getOptionText());
        }
    }

    public Option getSelection(Option[] actions) {
        System.out.print("What are you going to do:");
        int selection = in.nextInt();
        return actions[selection - 1];
    }
}

package textrpg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import textrpg.game.GameScene;
import textrpg.game.Option;
import textrpg.game.Result;
import textrpg.game.SceneController;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // launch();

        SceneController sceneController = new SceneController();

        GameScene startingScene = new GameScene("A Journey's First Step",
                "Our hero boldly ventures out into the world.");

        Option exploreForest = new Option("Explore the forest", "Venture into the forest to gather supplies",
               new Result("You find a thing"));
        Option buildCampsite = new Option("Prepare campsite",
                "Gather materials from the immediate area and build a campsite for the night", new Result("You camped overnight"));
        Option goHome = new Option("Go back home",
                "You know, maybe this adventuring stuff isn't really for me. I'm just gonna head home.", new Result("Game End"));

        Option[] actions = new Option[] { exploreForest, buildCampsite, goHome };

        startingScene.setActions(actions);

        sceneController.playScene(startingScene);
    }
}
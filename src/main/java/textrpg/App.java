package textrpg;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import textrpg.dao.implementations.SceneDAOImpl;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.game.SceneController;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.utils.ActionType;

/** JavaFX App */
public class App extends Application {

  private static javafx.scene.Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new javafx.scene.Scene(loadFXML("primary"), 640, 480);
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

    SceneDAO gsDAO = new SceneDAOImpl();

    // Scene startingScene = new Scene("A Journey's First Step",
    // "Our hero boldly ventures out into the world.");
    Scene startingScene = gsDAO.getById(1);

    Action exploreForest =
        new Action(
            ActionType.EVENT_TRIGGER,
            "Explore the forest",
            "Venture into the forest to gather supplies",
            "Found: Wild Game");
    Action buildCampsite =
        new Action(
            ActionType.EVENT_TRIGGER,
            "Prepare campsite",
            "Gather materials from the immediate area and build a campsite for the night",
            "Health Restored");
    Action goHome =
        new Action(
            ActionType.EVENT_TRIGGER,
            "Go back home",
            "You know, maybe this adventuring stuff isn't really for me. I'm just gonna head home.",
            "The End");

    Action[] actions = new Action[] {exploreForest, buildCampsite, goHome};

    startingScene.setActions(actions);

    sceneController.playScene(startingScene);
  }
}

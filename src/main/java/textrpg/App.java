package textrpg;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import textrpg.dao.implementations.SceneDAOImpl;
import textrpg.dao.interfaces.SceneDAO;
import textrpg.game.SceneController;
import textrpg.models.Action;
import textrpg.models.Scene;
import textrpg.utils.ActionType;

public class App {
  private static Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws InterruptedException {
    logger.info("Starting application...");
    SceneController sceneController = new SceneController();

    logger.debug("THIS IS A DEBUG LOG");

    for (int i = 1; i < 1000000; i++) {
      logger.info("Test Rolling Log: " + i);
      TimeUnit.MILLISECONDS.sleep(1);
    }

    SceneDAO gsDAO = new SceneDAOImpl();

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
    logger.info("Closing application...");
  }
}

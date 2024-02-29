package textrpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import textrpg.dao.implementations.WorldStateDAOImpl;
import textrpg.dao.interfaces.WorldStateDAO;
import textrpg.game.GameController;
import textrpg.models.WorldState;

public class App {
  private static Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) throws InterruptedException {
    logger.info("Starting application...");

    WorldStateDAO worldStateDAO = new WorldStateDAOImpl();

    WorldState worldState = worldStateDAO.getWorldStateById(1);
    GameController gameController = new GameController(worldState);

    while (true) {
      gameController.playCurrentScene();
    }

    // logger.info("Closing application...");
  }
}

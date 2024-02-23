package textrpg.game;

public class Result {
    private String text;
    private GameScene nextScene;

    public Result(GameScene nextScene, String text) {
        this.nextScene = nextScene;
        this.text = text;
    }

    public GameScene getNextScene() {
        return nextScene;
    }

    public String getOutcome() {
        return text;
    }
}

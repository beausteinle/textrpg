package textrpg.game;

public class Result {


    private String resultDescription;
    private GameScene nextScene;

    public Result(GameScene nextScene, String resultDescription) {
        this.nextScene = nextScene;
        this.resultDescription = resultDescription;
    }

    public Result(String resultDescription){
        this.resultDescription = resultDescription;
    }

    public GameScene getNextScene() {
        return nextScene;
    }

    public String getResultDescription() {
        return resultDescription;
    }
}

package textrpg.models;

public class Result {

  private String resultDescription;
  private Scene nextScene;

  public Result(Scene nextScene, String resultDescription) {
    this.nextScene = nextScene;
    this.resultDescription = resultDescription;
  }

  public Result(String resultDescription) {
    this.resultDescription = resultDescription;
  }

  public Scene getNextScene() {
    return nextScene;
  }

  public String getResultDescription() {
    return resultDescription;
  }
}

package textrpg.models;

public class Outcome {

  // TODO ADD ATTRIBUTE 'resultId'
  private String resultDescription;
  private Scene nextScene;

  public Outcome(Scene nextScene, String resultDescription) {
    this.nextScene = nextScene;
    this.resultDescription = resultDescription;
  }

  public Outcome(String resultDescription) {
    this.resultDescription = resultDescription;
  }

  public Scene getNextScene() {
    return nextScene;
  }

  public String getResultDescription() {
    return resultDescription;
  }
}

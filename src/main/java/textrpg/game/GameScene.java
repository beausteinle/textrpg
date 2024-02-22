package textrpg.game;

public class GameScene {
    String title;
    String description;

    Option[] actions;

    public GameScene(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setActions(Option[] actions) {
        this.actions = actions;
    }

    public Option[] getActions() {
        return actions;
    }
}

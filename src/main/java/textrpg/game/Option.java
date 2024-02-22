package textrpg.game;

public class Option {
    String title;
    String description;

    Result result;

    public Option(String title, String description, String result) {
        this.title = title;
        this.description = description;
        this.result = new Result(result);
    }

    public String getOptionText() {
        return String.format("%s: %s", title, description);
    }

    public Result getResult() {
        return result;
    }
}

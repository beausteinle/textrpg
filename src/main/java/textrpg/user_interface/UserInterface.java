package textrpg.user_interface;

import textrpg.models.Action;
import textrpg.models.Scene;

public interface UserInterface {
    public String displayScene(Scene scene);

    public String displayActions(Action[] actions);
}

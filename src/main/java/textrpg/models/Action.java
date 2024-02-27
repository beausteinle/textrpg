package textrpg.models;

import textrpg.utils.ActionType;

public class Action {
  String title;
  String description;

  Result result;

  ActionType actionType;

  public Action(ActionType actionType, String title, String description, String result) {

    this.title = title;
    this.description = description;
    this.result = new Result(result);
  }

  public ActionType getActionType() {
    return actionType;
  }

  public void setActionType() {
    this.actionType = actionType;
  }

  public String getActionText() {
    return String.format("%s: %s", title, description);
  }

  public Result getResult() {
    return result;
  }
}

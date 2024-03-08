package textrpg.models;

import textrpg.utils.ActionType;

public class Action {
  // TODO ADD actionId Class Attribute
  String title;
  String description;
  Outcome outcome;

  ActionType actionType;

  public Action(ActionType actionType, String title, String description, String outcome) {

    this.title = title;
    this.description = description;
    this.outcome = new Outcome(outcome);
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

  public Outcome getResult() {
    return outcome;
  }
}

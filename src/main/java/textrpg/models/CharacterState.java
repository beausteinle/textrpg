package textrpg.models;

import textrpg.utils.WorldPosition;

public class CharacterState {
  WorldPosition worldPosition;

  public CharacterState(WorldPosition worldPosition) {
    this.worldPosition = worldPosition;
  }

  public WorldPosition getWorldPosition() {
    return worldPosition;
  }

  public void setWorldPosition(WorldPosition worldPosition) {
    this.worldPosition = worldPosition;
  }
}

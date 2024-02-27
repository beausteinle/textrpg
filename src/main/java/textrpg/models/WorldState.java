package textrpg.models;

public class WorldState {
  int worldStateId;
  CharacterState characterState;

  public WorldState(int id, CharacterState characterState) {
    this.characterState = characterState;
    worldStateId = id;
  }

  public CharacterState getCharacterState() {
    return characterState;
  }

  public void setCharacterState(CharacterState characterState) {
    this.characterState = characterState;
  }
}

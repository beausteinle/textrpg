package textrpg.models;

public class WorldState {
    CharacterState characterState;


    public WorldState(CharacterState characterState) {
        this.characterState = characterState;
    }

    public CharacterState getCharacterState() {
        return characterState;
    }

    public void setCharacterState(CharacterState characterState) {
        this.characterState = characterState;
    }
}

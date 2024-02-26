package textrpg.dao.interfaces;

import textrpg.models.Scene;

public interface SceneDAO {
    public Scene getById(int scene_id);
    public Scene getByLocation(int region_id, String location_key);
}

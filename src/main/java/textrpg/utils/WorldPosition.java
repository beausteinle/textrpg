package textrpg.utils;

public class WorldPosition {
    int regionId;
    int xLocation;
    int yLocation;

    public WorldPosition(int regionId, int xLocation, int yLocation) {
        this.regionId = regionId;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public void setWorldPosition(WorldPosition newWorldPosition){
        this.regionId = newWorldPosition.getRegionId();
        this.xLocation = newWorldPosition.getxLocation();
        this.yLocation = newWorldPosition.getyLocation();
    }
}

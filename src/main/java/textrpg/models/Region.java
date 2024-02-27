package textrpg.models;

public class Region {
  int regionId;
  String title;
  String description;

  public Region(int regionId, String title, String description) {
    this.regionId = regionId;
    this.title = title;
    this.description = description;
  }
}

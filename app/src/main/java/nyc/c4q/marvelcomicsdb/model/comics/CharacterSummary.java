package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CharacterSummary extends RealmObject{
  private String resourceuri;
  private String name;
  private String type;

  public String getResourceuri() {
    return resourceuri;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
}

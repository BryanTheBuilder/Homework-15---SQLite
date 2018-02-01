package nyc.c4q.marvelcomicsdb.model.character;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CharacterEventSummary extends RealmObject {

  private String resourceURI;
  private String name;

  public String getResourceURI() {
    return resourceURI;
  }

  public String getName() {
    return name;
  }
}

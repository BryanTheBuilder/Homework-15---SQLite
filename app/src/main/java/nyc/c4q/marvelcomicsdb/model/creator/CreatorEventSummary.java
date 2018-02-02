package nyc.c4q.marvelcomicsdb.model.creator;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CreatorEventSummary extends RealmObject {

  private String resourceURI;
  private String name;

  public String getResourceURI() {
    return resourceURI;
  }

  public String getName() {
    return name;
  }
}

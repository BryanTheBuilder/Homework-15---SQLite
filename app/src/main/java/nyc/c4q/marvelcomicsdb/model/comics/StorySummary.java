package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.RealmObject;

/**
 * Created by c4q on 1/29/18.
 */

public class StorySummary extends RealmObject {
  private String resourceURI;
  private String name;

  public String getResourceURI() {
    return resourceURI;
  }

  public String getName() {
    return name;
  }
}

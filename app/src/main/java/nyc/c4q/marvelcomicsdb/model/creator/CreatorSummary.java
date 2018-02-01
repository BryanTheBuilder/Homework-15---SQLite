package nyc.c4q.marvelcomicsdb.model.creator;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CreatorSummary extends RealmObject{
  private String resourceURI;
  private String name;
  private String role;

  public String getResourceURI() {
    return resourceURI;
  }

  public String getName() {
    return name;
  }

  public String getRole() {
    return role;
  }
}

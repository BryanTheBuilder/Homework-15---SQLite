package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class ComicDate extends RealmObject {
  private String type;
  private String date;

  public String getType() {
    return type;
  }

  public String getDate() {
    return date;
  }
}

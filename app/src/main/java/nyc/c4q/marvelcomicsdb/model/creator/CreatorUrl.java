package nyc.c4q.marvelcomicsdb.model.creator;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CreatorUrl extends RealmObject{
    private String type;
    private String url;

    public String getType() {
      return type;
    }

    public String getUrl() {
      return url;
    }
  }
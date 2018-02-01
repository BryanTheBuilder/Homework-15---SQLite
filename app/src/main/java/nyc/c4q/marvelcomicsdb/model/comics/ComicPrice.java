package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class ComicPrice extends RealmObject{

  private String type;
  private float price;

  public String getType() {
    return type;
  }

  public float getPrice() {
    return price;
  }

}

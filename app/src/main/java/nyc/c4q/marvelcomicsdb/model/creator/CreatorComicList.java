package nyc.c4q.marvelcomicsdb.model.creator;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CreatorComicList extends RealmObject {

  private int available;
  private int returned;
  private String collectionURI;
  private RealmList<CreatorComicSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public RealmList<CreatorComicSummary> getItems() {
    return items;
  }

}

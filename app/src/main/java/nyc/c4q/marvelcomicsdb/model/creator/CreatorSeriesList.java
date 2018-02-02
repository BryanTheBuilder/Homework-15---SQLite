package nyc.c4q.marvelcomicsdb.model.creator;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;


public class CreatorSeriesList extends RealmObject {

  private int available;
  private int returned;
  private String collectionURI;
  private RealmList<CreatorSeriesSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public RealmList<CreatorSeriesSummary> getItems() {
    return items;
  }

}

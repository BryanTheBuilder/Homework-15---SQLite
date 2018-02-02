package nyc.c4q.marvelcomicsdb.model.creator;


import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;

public class CreatorEventList extends RealmObject{

  private int available;
  private int returned;
  private String collectionURI;
  private RealmList<CreatorEventSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public RealmList<CreatorEventSummary> getItems() {
    return items;
  }

}

package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.RealmList;
import io.realm.RealmObject;
import nyc.c4q.marvelcomicsdb.model.creator.CreatorSummary;

public class CreatorList extends RealmObject {

  private int available;
  private int returned;
  private String collectionURI;
  private RealmList<CreatorSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public RealmList<CreatorSummary> getItems() {
    return items;
  }

}

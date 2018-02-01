package nyc.c4q.marvelcomicsdb.model.character;

import io.realm.RealmList;
import io.realm.RealmObject;
import nyc.c4q.marvelcomicsdb.model.comics.EventSummary;

/**
 * Created by c4q on 2/1/18.
 */

public class CharacterEventList extends RealmObject {

  private int available;
  private int returned;
  private String collectionURI;
  private RealmList<CharacterEventSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public RealmList<CharacterEventSummary> getItems() {
    return items;
  }

}

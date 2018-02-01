package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;

public class CharacterList extends RealmObject {

  private int available;
  private int returned;
  private String collectionuri;
  private RealmList<CharacterSummary> items;

  public int getAvailable() {
    return available;
  }

  public int getReturned() {
    return returned;
  }

  public String getCollectionuri() {
    return collectionuri;
  }

  public RealmList<CharacterSummary> getItems() {
    return items;
  }

}

package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;

public class StoryList extends RealmObject {
    private int available;
    private int returned;
    private String collectionURI;
    private RealmList<StorySummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public RealmList<StorySummary> getItems() {
        return items;
    }

}

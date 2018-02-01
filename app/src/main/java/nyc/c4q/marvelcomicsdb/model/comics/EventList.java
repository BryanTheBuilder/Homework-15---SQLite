package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;

public class EventList extends RealmObject {
    private int available;
    private int returned;
    private String collectionURI;
    private RealmList<EventSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public RealmList<EventSummary> getItems() {
        return items;
    }
}

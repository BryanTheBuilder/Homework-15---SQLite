package nyc.c4q.marvelcomicsdb.model.character;

import io.realm.RealmList;
import io.realm.RealmObject;
import java.util.List;
import nyc.c4q.marvelcomicsdb.model.comics.ComicSummary;

public class ComicList extends RealmObject {
    private int available;
    private int returned;
    private String collectionURI;
    private RealmList<ComicSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public RealmList<ComicSummary> getItems() {
        return items;
    }


}

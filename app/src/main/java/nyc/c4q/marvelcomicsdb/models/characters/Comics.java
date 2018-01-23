package nyc.c4q.marvelcomicsdb.models.characters;


import java.util.List;

public class Comics {
    private int available;
    private String collectionuri;
    private List<Items> items;
    private int returned;

    public int getAvailable() {
        return available;
    }

    public String getCollectionuri() {
        return collectionuri;
    }

    public List<Items> getItems() {
        return items;
    }

    public int getReturned() {
        return returned;
    }
}

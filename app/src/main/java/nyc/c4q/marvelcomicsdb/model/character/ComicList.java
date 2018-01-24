package nyc.c4q.marvelcomicsdb.model.character;

import java.util.List;

public class ComicList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<ComicSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<ComicSummary> getItems() {
        return items;
    }

    public static class ComicSummary {
        private String resourceURI;
        private String name;

        public String getResourceURI() {
            return resourceURI;
        }

        public String getName() {
            return name;
        }
    }
}

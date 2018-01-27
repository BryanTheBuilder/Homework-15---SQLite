package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.List;

public class StoryList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<StorySummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<StorySummary> getItems() {
        return items;
    }

    private static class StorySummary {
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

package nyc.c4q.marvelcomicsdb.model;

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

    public static class StorySummary {
        private String resourceURI;
        private String name;
        private String type;

        public String getResourceURI() {
            return resourceURI;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }
}
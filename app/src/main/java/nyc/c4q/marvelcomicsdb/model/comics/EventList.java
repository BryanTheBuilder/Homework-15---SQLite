package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.List;

public class EventList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<EventSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<EventSummary> getItems() {
        return items;
    }

    private static class EventSummary {
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

package nyc.c4q.marvelcomicsdb.model;


import java.util.List;

public class Series {
    private String available;
    private String returned;
    private String collectionUri;
    private List<Items> items;

    public String getAvailable() {
        return available;
    }

    public String getReturned() {
        return returned;
    }

    public String getCollectionUri() {
        return collectionUri;
    }

    public List<Items> getItems() {
        return items;
    }

    public static class Items {
        private String resourceUri;
        private String name;

        public String getResourceUri() {
            return resourceUri;
        }

        public String getName() {
            return name;
        }
    }
}
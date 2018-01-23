package nyc.c4q.marvelcomicsdb.model;

import java.util.List;

public class Events {
    private String available;
    private String returned;
    private String collectionuri;
    private List<Items> items;

    public String getAvailable() {
        return available;
    }

    public String getReturned() {
        return returned;
    }

    public String getCollectionuri() {
        return collectionuri;
    }

    public List<Items> getItems() {
        return items;
    }

    public static class Items {
        private String resourceuri;
        private String name;

        public String getResourceuri() {
            return resourceuri;
        }

        public String getName() {
            return name;
        }
    }
}

package nyc.c4q.marvelcomicsdb.model;


import java.util.List;

public class SeriesList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<SeriesSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<SeriesSummary> getItems() {
        return items;
    }

    public static class SeriesSummary {
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
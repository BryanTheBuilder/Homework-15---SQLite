package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.List;

public class CreatorList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<CreatorSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<CreatorSummary> getItems() {
        return items;
    }

    private static class CreatorSummary {
        private String resourceURI;
        private String name;
        private String role;

        public String getResourceURI() {
            return resourceURI;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }
    }
}

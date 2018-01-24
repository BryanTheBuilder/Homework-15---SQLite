package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.List;

public class CharacterList {
    private int available;
    private int returned;
    private String collectionuri;
    private List<CharacterSummary> items;

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionuri() {
        return collectionuri;
    }

    public List<CharacterSummary> getItems() {
        return items;
    }

    private static class CharacterSummary {
        private String resourceuri;
        private String name;
        private String type;

        public String getResourceuri() {
            return resourceuri;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }
}

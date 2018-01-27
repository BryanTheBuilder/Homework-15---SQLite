package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.Date;
import java.util.List;

public class Comic {
    private int id;
    private int digitalId;
    private String title;
    private double issueNumber;
    private String variantDescription;
    private String description;
    private String modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private int pageCount;
    private List<TextObject> textObjects;
    private String resourceURI;
    private List<Url> urls;
    private SeriesSummary series;
    private List<ComicSummary> variants;
    private List<ComicSummary> collections;
    private List<ComicSummary> collectedIssues;
    private List<ComicDate> dates;
    private List<ComicPrice> prices;
    private Image thumbnail;
    private List<Image> images;
    private CreatorList creators;
    private CharacterList characters;
    private StoryList stories;
    private EventList events;

    public int getId() {
        return id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUpc() {
        return upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public String getIssn() {
        return issn;
    }

    public String getFormat() {
        return format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public List<TextObject> getTextObjects() {
        return textObjects;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public SeriesSummary getSeries() {
        return series;
    }

    public List<ComicSummary> getVariants() {
        return variants;
    }

    public List<ComicSummary> getCollections() {
        return collections;
    }

    public List<ComicSummary> getCollectedIssues() {
        return collectedIssues;
    }

    public List<ComicDate> getDates() {
        return dates;
    }

    public List<ComicPrice> getPrices() {
        return prices;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public List<Image> getImages() {
        return images;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public StoryList getStories() {
        return stories;
    }

    public EventList getEvents() {
        return events;
    }

    private static class ComicSummary {
        private String resourceURI;
        private String name;

        public String getResourceURI() {
            return resourceURI;
        }

        public String getName() {
            return name;
        }
    }

    private static class ComicDate {
        private String type;
        private String date;

        public String getType() {
            return type;
        }

        public String getDate() {
            return date;
        }
    }

    private static class ComicPrice {
        private String type;
        private float price;

        public String getType() {
            return type;
        }

        public float getPrice() {
            return price;
        }
    }
}

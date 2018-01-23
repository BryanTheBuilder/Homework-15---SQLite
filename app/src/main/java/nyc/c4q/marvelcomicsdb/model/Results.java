package nyc.c4q.marvelcomicsdb.model;


import java.util.List;

public class Results {
    private String id;
    private String name;
    private String description;
    private String modified;
    private String resourceuri;
    private List<Urls> urls;
    private Thumbnail thumbnail;
    private Comics comics;
    private Stories stories;
    private Events events;
    private Series series;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getResourceuri() {
        return resourceuri;
    }

    public List<Urls> getUrls() {
        return urls;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Comics getComics() {
        return comics;
    }

    public Stories getStories() {
        return stories;
    }

    public Events getEvents() {
        return events;
    }

    public Series getSeries() {
        return series;
    }
}

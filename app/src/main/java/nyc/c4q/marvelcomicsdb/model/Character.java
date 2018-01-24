package nyc.c4q.marvelcomicsdb.model;


import java.util.Date;
import java.util.List;

public class Character {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceuri;
    private List<Url> urls;
    private Image image;
    private ComicList comics;
    private StoryList stories;
    private EventList events;
    private SeriesList series;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getModified() {
        return modified;
    }

    public String getResourceuri() {
        return resourceuri;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public Image getImage() {
        return image;
    }

    public ComicList getComics() {
        return comics;
    }

    public StoryList getStories() {
        return stories;
    }

    public EventList getEvents() {
        return events;
    }

    public SeriesList getSeries() {
        return series;
    }
}

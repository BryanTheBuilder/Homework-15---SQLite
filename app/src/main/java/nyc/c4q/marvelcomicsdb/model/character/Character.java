package nyc.c4q.marvelcomicsdb.model.character;


import java.util.Date;
import java.util.List;

public class Character {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<Url> urls;
    private Image thumbnail;
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

    public String getResourceURI() {
        return resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public Image getThumbnail() {
        return thumbnail;
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

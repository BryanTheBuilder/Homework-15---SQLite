package nyc.c4q.marvelcomicsdb.model.creator;


import java.util.Date;
import java.util.List;

public class Creator {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private Date modified;
    private String resourceURI;
    private List<Url> urls;
    private Image thumbnail;
    private SeriesList series;
    private StoryList stories;
    private ComicList comics;
    private EventList events;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
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

    public SeriesList getSeries() {
        return series;
    }

    public StoryList getStories() {
        return stories;
    }

    public ComicList getComics() {
        return comics;
    }

    public EventList getEvents() {
        return events;
    }
}

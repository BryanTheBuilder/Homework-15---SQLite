package nyc.c4q.marvelcomicsdb.model.character;


import android.os.Parcel;
import android.os.Parcelable;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import java.util.Date;
import java.util.List;

public class Character extends RealmObject {

  @PrimaryKey
  private int _id;

  @Index
  private int id;
  @Index
  private String name;

  private String description;
  private Date modified;
  private String resourceURI;
  private RealmList<Url> urls;
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

  public RealmList<Url> getUrls() {
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

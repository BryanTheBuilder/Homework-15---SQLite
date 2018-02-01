package nyc.c4q.marvelcomicsdb.model.character;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import java.util.Date;

public class Character extends RealmObject {

  @PrimaryKey
  private int _id;

  @Index
  private int id;
  @Index
  private String name;
  @Index
  private boolean isFavorite;

  public void setFavorite(boolean favorite) {
    isFavorite = favorite;
  }

  private String description;
  private Date modified;
  private String resourceURI;
  private RealmList<Url> urls;
  private CharacterImage thumbnail;
  private ComicList comics;
  private CharacterStoryList stories;
  private CharacterEventList events;
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

  public CharacterImage getThumbnail() {
    return thumbnail;
  }

  public ComicList getComics() {
    return comics;
  }

  public CharacterStoryList getStories() {
    return stories;
  }

  public CharacterEventList getEvents() {
    return events;
  }

  public SeriesList getSeries() {
    return series;
  }

}

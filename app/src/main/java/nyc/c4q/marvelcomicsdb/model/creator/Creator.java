package nyc.c4q.marvelcomicsdb.model.creator;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Creator extends RealmObject {

  @PrimaryKey
  private long _id;
  @Index
  private int id;
  private String firstName;
  private String lastName;
  @Index
  private String fullName;
  private String modified;
  private String resourceURI;
  private RealmList<CreatorUrl> urls;
  private CreatorImage thumbnail;
  private CreatorSeriesList series;
  private CreatorStoryList stories;
  private CreatorComicList comics;
  private CreatorEventList events;

  @Index
  private boolean isFavorite;

  public void setFavorite(boolean favorite) {
    isFavorite = favorite;
  }


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

  public String getModified() {
    return modified;
  }

  public String getResourceURI() {
    return resourceURI;
  }

  public RealmList<CreatorUrl> getUrls() {
    return urls;
  }

  public CreatorImage getThumbnail() {
    return thumbnail;
  }

  public CreatorSeriesList getSeries() {
    return series;
  }

  public CreatorStoryList getStories() {
    return stories;
  }

  public CreatorComicList getComics() {
    return comics;
  }

  public CreatorEventList getEvents() {
    return events;
  }
}

package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Comic extends RealmObject {

  @PrimaryKey
  private long _id;
  @Index
  private int id;
  @Index
  private int digitalId;
  @Index
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
  private RealmList<TextObject> textObjects;
  private String resourceURI;
  private RealmList<ComicUrl> comicUrls;
  private SeriesSummary series;
  private RealmList<ComicSummary> variants;
  private RealmList<ComicSummary> collections;
  private RealmList<ComicSummary> collectedIssues;
  private RealmList<ComicDate> dates;
  private RealmList<ComicPrice> prices;
  private Image thumbnail;
  private RealmList<Image> images;
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

  public RealmList<TextObject> getTextObjects() {
    return textObjects;
  }

  public String getResourceURI() {
    return resourceURI;
  }

  public RealmList<ComicUrl> getComicUrls() {
    return comicUrls;
  }

  public SeriesSummary getSeries() {
    return series;
  }

  public RealmList<ComicSummary> getVariants() {
    return variants;
  }

  public RealmList<ComicSummary> getCollections() {
    return collections;
  }

  public RealmList<ComicSummary> getCollectedIssues() {
    return collectedIssues;
  }

  public RealmList<ComicDate> getDates() {
    return dates;
  }

  public RealmList<ComicPrice> getPrices() {
    return prices;
  }

  public Image getThumbnail() {
    return thumbnail;
  }

  public RealmList<Image> getImages() {
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

}

package nyc.c4q.marvelcomicsdb.model.character;

import io.realm.RealmObject;

/**
 * Created by c4q on 2/1/18.
 */

public class CharacterImage extends RealmObject {

  private String path;
  private String extension;

  public String getPath() {
    return path;
  }

  public String getExtension() {
    return extension;
  }
}

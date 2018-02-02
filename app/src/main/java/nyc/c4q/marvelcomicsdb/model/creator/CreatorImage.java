package nyc.c4q.marvelcomicsdb.model.creator;


import io.realm.RealmObject;

public class CreatorImage extends RealmObject {
    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}

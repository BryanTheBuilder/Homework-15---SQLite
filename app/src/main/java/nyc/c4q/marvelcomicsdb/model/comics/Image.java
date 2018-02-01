package nyc.c4q.marvelcomicsdb.model.comics;


import io.realm.RealmObject;

public class Image extends RealmObject {
    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}

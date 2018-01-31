package nyc.c4q.marvelcomicsdb.model.character;


import io.realm.RealmObject;

public class Url extends RealmObject{
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}

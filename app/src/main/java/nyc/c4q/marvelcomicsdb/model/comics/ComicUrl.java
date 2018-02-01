package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.Realm;
import io.realm.RealmObject;

public class ComicUrl extends RealmObject{
    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}

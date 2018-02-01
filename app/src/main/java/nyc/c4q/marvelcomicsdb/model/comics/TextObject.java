package nyc.c4q.marvelcomicsdb.model.comics;

import io.realm.RealmObject;

public class TextObject extends RealmObject {
    private String type;
    private String language;
    private String text;

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }
}
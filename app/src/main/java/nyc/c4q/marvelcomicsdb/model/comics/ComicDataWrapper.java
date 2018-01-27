package nyc.c4q.marvelcomicsdb.model.comics;


public class ComicDataWrapper {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private ComicDataContainer data;
    private String etag;

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public ComicDataContainer getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }
}

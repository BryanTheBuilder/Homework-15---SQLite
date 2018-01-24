package nyc.c4q.marvelcomicsdb.model.creator;


public class CreatorDataWrapper {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private CreatorDataContainer data;
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

    public CreatorDataContainer getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }
}

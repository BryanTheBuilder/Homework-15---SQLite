package nyc.c4q.marvelcomicsdb.model;


public class Characters {
    private String code;
    private String status;
    private String copyright;
    private String attributiontext;
    private String attributionhtml;
    private Data data;
    private String etag;

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributiontext() {
        return attributiontext;
    }

    public String getAttributionhtml() {
        return attributionhtml;
    }

    public Data getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }




    public static class Items {
        private String resourceuri;
        private String name;

        public String getResourceuri() {
            return resourceuri;
        }

        public String getName() {
            return name;
        }
    }













}

package nyc.c4q.marvelcomicsdb.model;


import java.util.List;

public class Data {
    private String offset;
    private String limit;
    private String total;
    private String count;
    private List<Results> results;

    public String getOffset() {
        return offset;
    }

    public String getLimit() {
        return limit;
    }

    public String getTotal() {
        return total;
    }

    public String getCount() {
        return count;
    }

    public List<Results> getResults() {
        return results;
    }
}

package nyc.c4q.marvelcomicsdb.model.comics;


import java.util.List;

public class ComicDataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Comic> results;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<Comic> getResults() {
        return results;
    }
}

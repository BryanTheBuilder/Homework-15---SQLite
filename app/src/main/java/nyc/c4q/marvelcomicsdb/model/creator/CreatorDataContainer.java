package nyc.c4q.marvelcomicsdb.model.creator;


import java.util.List;

public class CreatorDataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Creator> results;

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

    public List<Creator> getResults() {
        return results;
    }
}

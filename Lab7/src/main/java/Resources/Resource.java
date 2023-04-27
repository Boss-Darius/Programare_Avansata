package Resources;

public class Resource {
    private int[] tokens;
    private int dimension;
    private Object Lock;

    public Resource(int dimension) {
        Lock = new Object();
        this.dimension = dimension;
        tokens = new int[dimension * dimension * dimension];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = i;
        }
    }

    public int[] getTokens() {
        return tokens;
    }

    public int getDimension() {
        return dimension;
    }
}

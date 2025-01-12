public class Flower {
    private int currentHeight;
    private int maxHeight;

    public Flower(int maxHeight) {
        this.currentHeight = 0;
        this.maxHeight = maxHeight;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public void grow(int growthAmount) {
        currentHeight = Math.min(currentHeight + growthAmount, maxHeight);
    }

    public boolean isFullyGrown() {
        return currentHeight >= maxHeight;
    }
}

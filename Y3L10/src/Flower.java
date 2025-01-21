import java.util.Random;

public class Flower {
    private int curH;
    private int maxH;
    Random random = new Random();

    public Flower() {
        curH = 50;
        maxH = random.nextInt(100)+100;
        while (maxH % 5 !=0)
            maxH=random.nextInt(100)+100;
    }
    public boolean isFullyGrown(){
        return !(curH<maxH);
    }

    public void setCurH(int curH) {
        this.curH = curH;
    }

    public int getCurH() {
        return curH;
    }

    public int getMaxH() {
        return maxH;
    }
}

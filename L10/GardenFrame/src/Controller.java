import java.util.Random;
public class Controller {
    private Flower[] flowers;
    private Runnable call;
    Random rand = new Random();

    public Controller(Flower[] flowers, Runnable call) {
        this.flowers = flowers;
        this.call = call;
    }

    public void startGrowth() {
        for (Flower flower : flowers) {
            new Thread(() -> {
                while (!flower.isFullyGrown()) {
                    int growth = rand.nextInt(10) + 1;
                    flower.grow(growth);

                    call.run();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}

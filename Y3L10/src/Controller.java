import java.util.Random;

public class Controller {
    Flower flower;
    Random random = new Random();
    public void growFlower(Flower flower, Runnable call){

        new Thread(() -> {
            while (!flower.isFullyGrown()){
                flower.setCurH(flower.getCurH()+5);

                call.run();

                try {
                    Thread.sleep(random.nextInt(500)+500);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }

        }).start();

    }
}

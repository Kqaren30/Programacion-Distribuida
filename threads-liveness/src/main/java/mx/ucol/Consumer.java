package mx.ucol;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();

        for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
            System.out.format("%s [Consumer]:MESSAGE RECEIVED: %s%n",
                    Thread.currentThread().getName(),message);

            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}

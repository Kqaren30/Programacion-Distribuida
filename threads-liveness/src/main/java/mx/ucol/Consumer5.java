package mx.ucol;

import java.util.Random;

public class Consumer5 implements Runnable {
    private Drop drop;

    public Consumer5(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();

        for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);

            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}

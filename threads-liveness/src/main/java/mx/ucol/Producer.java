package mx.ucol;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
            "Hello this is",
            "only a test",
            "Made by Karen Robles"
        };

        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);
            System.out.format("%s [Producer]:Introduced '%s' to the Drop buffer%n",
                    Thread.currentThread().getName(),importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }

        drop.put("DONE");
    }
}

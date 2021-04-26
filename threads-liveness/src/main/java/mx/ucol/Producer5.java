package mx.ucol;

import java.util.Random;

public class Producer5 implements Runnable {
    private Drop drop;

    public Producer5(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Producer5:A9",
                "Producer5:A10"
        };

        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);

            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }

        drop.put("DONE");
    }
}

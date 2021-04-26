package mx.ucol;

import java.util.Random;

public class Producer2 implements Runnable {
    private Drop drop;

    public Producer2(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Producer2:A3",
                "Producer2:A4"
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

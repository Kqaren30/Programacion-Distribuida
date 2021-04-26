package mx.ucol;

import java.util.Random;

public class Producer3 implements Runnable {
    private Drop drop;

    public Producer3(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Producer3:A5",
                "Producer3:A6"
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
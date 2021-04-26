package mx.ucol;

import java.util.Random;

public class Producer4 implements Runnable {
    private Drop drop;

    public Producer4(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Producer4:A7",
                "Producer4:A8"
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

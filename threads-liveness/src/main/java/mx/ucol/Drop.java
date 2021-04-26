package mx.ucol;

import java.util.ArrayList;

public class Drop {
    //private String message = new String;
    private static ArrayList<String> message = new ArrayList<>();
    private boolean empty = true;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Someone interrupted this thread." + e);
            }
        }

        empty = true;
        notifyAll();

        //String ultimo = message.get(message.size() - 1);
        return message.get(message.size()-1);
        //message.remove(ultimo);
    }

    public synchronized void put(String message) {

            while (!empty) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }

            empty = false;

            this.message.add(message);

        notifyAll();
    }
}

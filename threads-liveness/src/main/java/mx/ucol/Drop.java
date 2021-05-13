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

        int ultimo = message.size() - 1;
        String mensaje =message.get(ultimo);
        //Con esas impresiones en consola verifico el tamaño de mi array
        //para saber que nunca sobrepasa el limite de 10
        //System.out.println("Tamaño de mi array:"+message.size() );
        message.remove(ultimo);
        //System.out.println("Tamaño de mi array:"+message.size() );
        return mensaje;
        //message.remove(ultimo);
    }

    public synchronized void put(String message) {

        int size = this.message.size();
        //System.out.println("Array:"+size);
        while ( !(this.message.isEmpty()) && size<10) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }

            empty = false;
        if(size>=10){System.out.println("Buffer is in the limit of 10 wait");}
        else {
            this.message.add(message);}

        notifyAll();
    }
}

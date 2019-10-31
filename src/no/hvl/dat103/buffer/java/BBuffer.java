package no.hvl.dat103.buffer.java;

import java.util.concurrent.Semaphore;

public class BBuffer {
    private Semaphore semCon;
    private Semaphore semProd;

    public BBuffer(){
        semCon = new Semaphore(0);
        semProd = new Semaphore(1);
    }

    void consume(){
        try {
            semCon.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Konsumerte enhet");
        semProd.release();
    }

    void produce(){
        try {
            semProd.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Produserte enhet");
        semCon.release();
    }
}

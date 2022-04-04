package zad1.a;

import zad1.a.Buffer;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {


    Buffer b;
    int number;


    public Consumer(Buffer b){
        this.b=b;
    }


    @Override
    public void run() {
        while(true){
            number=b.get();
            if(number!=0) {
                System.out.println("Consumer-> " + number);
            }
            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*2));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

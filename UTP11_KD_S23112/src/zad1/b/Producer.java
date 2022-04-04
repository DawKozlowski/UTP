package zad1.b;

import zad1.a.Buffer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{

    int number;
    Buffer b;

    public Producer(Buffer b){
        this.b=b;
    }


    @Override
    public void run() {
    while(true){
            number=(int)(Math.random()*1000);
            b.put(number);
            System.out.println("Producer-> "+number);
        try {
            TimeUnit.SECONDS.sleep((long)(Math.random()*2));
        } catch (InterruptedException e) {
            return;
        }
    }
    }
}

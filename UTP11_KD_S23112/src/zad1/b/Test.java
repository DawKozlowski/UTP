package zad1.b;

import zad1.a.Buffer;
import zad1.a.Consumer;
import zad1.a.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        Buffer b = new Buffer(20);
        Producer producer = new Producer(b);
        Consumer consumer = new Consumer(b);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(producer);
        executorService.execute(consumer);


        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }

}

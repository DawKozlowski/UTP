package zad1.b;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    Lock lock = new ReentrantLock();

    int capacity;
    int element;

    public Buffer(int capacity){
      this.capacity=capacity;
    }

    ArrayBlockingQueue<Integer> bufor = new ArrayBlockingQueue<Integer>(capacity);

    public int get(){
        lock.lock();
        try {
            element= bufor.take();
           return element;
        }catch (InterruptedException exc){
            return element;
        } finally{
            lock.unlock();
        }
    }

    public void put(int number){
        lock.lock();
            try {
                bufor.put(number);
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
    }

}

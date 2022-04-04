package zad1.a;

import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    Deque<Integer> bufor = new ArrayDeque<Integer>();
    Lock lock = new ReentrantLock();
    Condition getter = lock.newCondition();
    Condition putter = lock.newCondition();

    int capacity;
    int element;
    boolean getStopped=false;
    boolean putStopped=false;

    public Buffer(int capacity){
      this.capacity=capacity;
    }

    public int get(){
        lock.lock();
        try {
            if(bufor.size() == 0) {
                getter.await();
                getStopped=true;
            }
            element = bufor.pollFirst();
            if(putStopped) {
                putter.signal();
                putStopped=false;
            }
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
                if(bufor.size()>=capacity) {
                    putter.await();
                    putStopped=true;
                }
                bufor.add(number);
                if(getStopped) {
                    getter.signal();
                    getStopped=false;
                }
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
    }

}

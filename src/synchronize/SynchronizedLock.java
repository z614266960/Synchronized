package synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: RuiJie Zhu
 * @Date: 2019/4/1 20:56
 * @PACKAGE_NAME: synchronize
 * @Description:
 *      还原Synchronized
 */
public class SynchronizedLock {
    Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        SynchronizedLock s = new SynchronizedLock();
        s.method1();
        s.method2();
    }

    public synchronized void method1(){
        System.out.println("this is m1");
    }

    public void method2(){
        lock.lock();
        try {
            System.out.println("this is m2");
        }finally {
            lock.unlock();
        }

    }
}

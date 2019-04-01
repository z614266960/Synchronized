package synchronize;

public class SynchronizedObjectCodeBlocks2 implements Runnable{
    static SynchronizedObjectCodeBlocks2 instance = new SynchronizedObjectCodeBlocks2();

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }
    @Override
    public void run() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        synchronized (lock1){
            System.out.println("lock1锁："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1结束："+Thread.currentThread().getName());
        }

        synchronized (lock2){
            System.out.println("lock2锁："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2结束："+Thread.currentThread().getName());
        }
    }
}

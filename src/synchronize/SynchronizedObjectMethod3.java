package synchronize;

public class SynchronizedObjectMethod3 implements Runnable{
    static SynchronizedObjectMethod3 instance1 = new SynchronizedObjectMethod3();
    static SynchronizedObjectMethod3 instance2 = new SynchronizedObjectMethod3();
    public static void main(String[] args){
        /*
            note:两个线程实现两个实例的话，方法锁等方式无用
         */
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }

    @Override
    public void run(){
        method();
    }

    public synchronized void method(){
        System.out.println("方法锁："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法锁："+Thread.currentThread().getName()+"结束");
    }
}

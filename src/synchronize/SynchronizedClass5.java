package synchronize;

public class SynchronizedClass5 implements Runnable{
    @Override
    public void run() {
        method();
    }
    /*
        note:class锁，可以锁住一个类所有的实例。
     */
    public void method(){
        synchronized (SynchronizedClass5.class){
            System.out.println("class对象锁"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finished");
        }
    }

    static SynchronizedClass5 instance1 = new SynchronizedClass5();
    static SynchronizedClass5 instance2 = new SynchronizedClass5();

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
}

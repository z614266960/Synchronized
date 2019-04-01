package synchronize;

/**
 * @Author: RuiJie Zhu
 * @Date: 2019/4/1 16:29
 * @PACKAGE_NAME: synchronize
 * @Description:
 * 分析：静态锁和非静态锁的目标资源不一致，所以两个同时运行。
 */
public class SynchronizedDifferentMethod7 implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }
    public static synchronized void method1(){
        System.out.println("静态加锁"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
    public synchronized void method2(){
        System.out.println("非静态锁"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }

    static SynchronizedDifferentMethod7 instance1 = new SynchronizedDifferentMethod7();
    static SynchronizedDifferentMethod7 instance2 = new SynchronizedDifferentMethod7();

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

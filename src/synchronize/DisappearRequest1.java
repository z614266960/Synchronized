package synchronize;
/*
    总结一下：
    1、一把锁只能被一个线程获取，其他等待
    2、不同实例产生的对象，有不同的锁，互相不影响。
        例外：.class锁，以及static锁
    3、正常执行和异常，锁都被释放
    4、锁方法调用非同步方法，不安全。因为非同步方法可以被多个线程同时访问
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i=0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }

    @Override
    public void run() {
        synchronized(this){
            for(int j=0;j<100000;j++){
                i++;
            }
        }

    }
}

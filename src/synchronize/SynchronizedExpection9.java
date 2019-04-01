package synchronize;

/**
 * @Author: RuiJie Zhu
 * @Date: 2019/4/1 16:38
 * @PACKAGE_NAME: synchronize
 * @Description:
 *      抛出异常，锁自动释放
 *      抛出RuntimeException也可以自动释放
 */
public class SynchronizedExpection9 implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else{
            method2();
        }
    }
    public synchronized void method1(){
        System.out.println("非静态加锁1"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
    public synchronized void method2(){
        System.out.println("非静态锁2"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }

    static SynchronizedExpection9 instance1 = new SynchronizedExpection9();

    public static void main(String[] args){
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance1);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }
}

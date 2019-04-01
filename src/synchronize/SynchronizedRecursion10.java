package synchronize;

/**
 * @Author: RuiJie Zhu
 * @Date: 2019/4/1 20:38
 * @PACKAGE_NAME: synchronize
 * @Description:
 *      可重入粒度测试
 *      1、自身递归没问题(method1)
 *      2、其他方法调用，没问题(method2-1)
 *      3、其他类方法调用，没问题（代码略）
 */
public class SynchronizedRecursion10 {
    public static void main(String[] args){
        SynchronizedRecursion10 s = new SynchronizedRecursion10();
        // 证实1猜想
        //s.method1();

        // 证实2猜想
        s.method2_1();
    }
    int a=0;

    private synchronized void method1() {
        System.out.println("into method1:a="+a);
        if(a==0){
            a++;
            method1();
        }
    }

    private synchronized void method2_1() {
        System.out.println("我是m2-1");
        method2_2();
    }
    private synchronized void method2_2() {
        System.out.println("我是m2-2");
    }
}

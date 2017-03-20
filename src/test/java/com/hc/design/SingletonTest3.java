package com.hc.design;

/**
 * 方法四
 * 优点：内存占用低，效率高，线程安全，多线程操作原子性
 */
public class SingletonTest3 {
    /**
     *  定义类型为SingletonTest3静态变量，使用volatile保证了多线程访问时instance变量的可见性，
     *  避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
     */
    private static volatile SingletonTest3 instance;

    //构造方法私有化
    private SingletonTest3() {

    }

    //静态方法返回实例
    public static SingletonTest3 newSingletonTest(SingletonTest3 instance) {
        if(instance == null){
            //同步代码块 保证多线程在访问对象时第一次被创建后不再被重复创建
            synchronized (SingletonTest3.class){
                //未初始化，则初始化instance变量
                if (instance == null){
                    instance = new SingletonTest3();
                }
            }
        }
        return instance;
    }
}

package com.hc.design;

/**
 * 方法三
 * 单例模式的实现：饱汉式，线程安全
 * 优点：使用synchronized关键字避免多线程访问，出现多个实例
 * 缺点：同步方法频繁被调用，效率低
 */
public class SingletonTest2 {
    //定义类型为SingletonTest2静态变量
    private static SingletonTest2 instance;

    //构造方法私有化
    private SingletonTest2() {

    }

    //静态方法返回实例 同步方法频繁被调用，效率低
    public static synchronized SingletonTest2 newSingletonTest(SingletonTest2 instance) {
        return (instance == null) ? new SingletonTest2() : instance;
    }
}

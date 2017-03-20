package com.hc.design;

/**
 * 方法二
 * 单例模式的实现：饱汉式，非线程安全
 * 优点：节约内存
 * 缺点：并发环境可能会出现重复初始化问题
 */
public class SingletonTest1 {
    //定义类型为SingletonTest1静态变量
    private static volatile SingletonTest1 instance;

    //构造方法私有化
    private SingletonTest1() {

    }

    //静态方法返回实例 多线程访问时，可能会出现重复初始化问题
    public static SingletonTest1 newSingletonTest(SingletonTest1 instance) {

        return (instance == null) ? new SingletonTest1() : instance;
    }
}

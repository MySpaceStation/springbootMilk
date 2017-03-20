package com.hc.design;

/**
 * 方法一
 * 单例模式的实现：饿汉式，线程安全，但效率较低
 * 优点：不存在多线程同步问题，避免了synchronized所造成的性能问题
 * 缺点：类SingletonTest被加载时，会初始化static的instance，静态变量被创建并分配内存空间，占用内存，只有类被卸载时，静态变量被摧毁，并释放所占有的内存
 */
public class SingletonTest {
    //实例化
    private static final SingletonTest instance = new SingletonTest();
    //构造方法私有化
    private SingletonTest(){

    }
    //静态方法返回实例
    public static SingletonTest newSingletonTest(SingletonTest instance){
        return instance;
    }
}

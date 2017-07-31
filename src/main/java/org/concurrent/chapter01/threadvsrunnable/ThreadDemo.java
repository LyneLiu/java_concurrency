package org.concurrent.chapter01.threadvsrunnable;

/**
 * 通过VirtualVM工具监控线程运行状态
 * Created by nn_liu on 2017/4/25.
 */
public class ThreadDemo extends Thread{

    private int num = 10;

    public ThreadDemo(String name){
        super(name);
    }

    public void run(){
        while (num > 0){
            System.out.println(String.format("%s-%d", Thread.currentThread().getName(), num--));
        }
    }

    public static void main(String[] args) {

        new ThreadDemo("ThreadDemoA").start();
        new ThreadDemo("ThreadDemoB").start();
        new ThreadDemo("ThreadDemoC").start();
        new ThreadDemo("ThreadDemoD").start();

    }

}

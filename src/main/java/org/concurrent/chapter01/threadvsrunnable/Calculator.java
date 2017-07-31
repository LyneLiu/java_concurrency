package org.concurrent.chapter01.threadvsrunnable;

/**
 * Java提供的创建线程的两种方式：
 * 1、继承Thread类，并且覆盖run()方法；
 * 2、创建一个实现Runnable接口的类，使用带参数的Thread构造器来创建Thread对象。
 *
 * Note: 如果某一个线程调用了System.exit()指令，所有的线程和当前进程都会结束。
 * <p>
 * Created by nn_liu on 2017/4/25.
 */
public class Calculator implements Runnable {

    private int num;

    public Calculator(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println(String.format("%s: %d * %d = %d \n", Thread.currentThread().getName(), num, i, i * num));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator, String.format("%s-%d", calculator.getClass().getSimpleName(), i));
            thread.start();
        }
    }
}

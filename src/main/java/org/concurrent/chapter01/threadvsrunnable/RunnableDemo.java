package org.concurrent.chapter01.threadvsrunnable;

/**
 * 关于使用Runnable还是Thread，可以参考相关资料，stackworkflow上边的建议是使用Runnable接口
 * 参考链接：http://stackoverflow.com/questions/541487/implements-runnable-vs-extends-thread
 * Created by nn_liu on 2017/4/25.
 */
public class RunnableDemo implements Runnable {

    private int num=10;

    @Override
    public void run() {
        while (num > 0){
            System.out.println(String.format("%s-%d", Thread.currentThread().getName(), num--));
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo,"RunnableDemoA").start();
        new Thread(runnableDemo,"RunnableDemoB").start();
        new Thread(runnableDemo,"RunnableDemoC").start();
        new Thread(runnableDemo,"RunnableDemoD").start();
    }
}

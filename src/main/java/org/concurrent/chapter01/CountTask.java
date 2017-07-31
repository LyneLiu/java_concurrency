package org.concurrent.chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask并发示例
 * Created by nn_liu on 2017/4/1.
 */

@Slf4j
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            /*如果不满足直接运算的条件，便添加子任务，并为其分工*/
            int middile = (start + end) / 2;

            CountTask leftTask = new CountTask(start, middile);
            CountTask rightTask = new CountTask(middile + 1, end);

            /*执行子任务：fork操作会将当前线程push至进程池并执行*/
            leftTask.fork();
            rightTask.fork();

            /*获取任务结果*/
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,9);
        Future<Integer> result = forkJoinPool.submit(task);

        try{
            log.info("task result...");
            System.out.println(String.valueOf(result.get()));
        }catch (InterruptedException e){
            log.error("InterruptedException:",e);
        } catch (ExecutionException e) {
            log.error("ExecutionException:",e);
        }

    }
}

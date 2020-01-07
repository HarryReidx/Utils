package cn.felord.datetime.convert;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(3);
        final ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            final int NO = i + 1;
            Runnable run = () -> {
                try {
                    // begin countDown 减完执行
                    begin.await();
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("No." + NO + " arrived");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            };
//            AbstractExecutorService
            // 三次run任务,线程此时是在队列中?
            exec.execute(run);
        }
        System.out.println("Game Start ...");
        begin.countDown();
        end.await();
        System.out.println("Game Over.");
        exec.shutdown();
    }
}
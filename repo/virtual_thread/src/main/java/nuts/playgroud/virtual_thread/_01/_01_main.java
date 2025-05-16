package nuts.playgroud.virtual_thread._01;

import java.util.concurrent.CountDownLatch;

public class _01_main {

    private static final int MAX_PLATFORM = 10_000;

    public static void main(String[] args) throws InterruptedException {
//        platformThreadDemo1();
        virtualThreadDemo();
    }

    private static void platformThreadDemo1() {
        for (int i = 0; i < 5; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

     private static void virtualThreadDemo() throws InterruptedException {
        var latch = new CountDownLatch(5);
        var builder = Thread.ofVirtual().name("virtual-", 1);
        for (int i = 0; i < 5; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
    }

}

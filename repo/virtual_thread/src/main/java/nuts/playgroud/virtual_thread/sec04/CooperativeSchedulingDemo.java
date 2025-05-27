package nuts.playgroud.virtual_thread.sec04;

import lombok.extern.slf4j.Slf4j;
import nuts.playgroud.virtual_thread.utils.CommonUtils;

import java.time.Duration;

@Slf4j
public class CooperativeSchedulingDemo {

  static {
        System.setProperty("jdk.virtualThreadScheduler.parallelism", "1");
        System.setProperty("jdk.virtualThreadScheduler.maxPoolSize", "1");
    }

    public static void main(String[] args) {

        var builder = Thread.ofVirtual();
        var t1 = builder.unstarted(() -> demo(1));
        var t2 = builder.unstarted(() -> demo(2));
        var t3 = builder.unstarted(() -> demo(3));
        t1.start();
        t2.start();
        t3.start();
        CommonUtils.sleep(Duration.ofSeconds(2));
    }

    private static void demo(int threadNumber) {
        log.info("thread-{} started", threadNumber);
        for (int i = 0; i < 10; i++) {
            log.info("thread-{} is printing {}. Thread: {}", threadNumber, i, Thread.currentThread());
//            Thread.yield(); // just for demo purposes
        }
        log.info("thread-{} ended", threadNumber);
    }
}

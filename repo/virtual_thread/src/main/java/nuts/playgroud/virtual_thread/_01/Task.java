package nuts.playgroud.virtual_thread._01;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class Task {

    public static void ioIntensive(int i) {

        try {
            log.info("start {} Thread info : {}", i, Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(10));
            log.info("end {} Thread info : {}", i, Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cpuIntensive(int i) {

    }
}

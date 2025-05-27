package nuts.playgroud.virtual_thread.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class CommonUtils {
    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

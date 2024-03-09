package bg.softuni.regular_exam.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
//    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 8-20 * * * ?")
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        Theme.darkTheme = false; //!Theme.darkTheme;
        System.out.println(Theme.darkTheme);
    }
    @Scheduled( cron="0 20-23,0-7 * * * ?")
    public void scheduleFixedDelayTask1() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        Theme.darkTheme = true; //!Theme.darkTheme;
        System.out.println(Theme.darkTheme);
    }
}

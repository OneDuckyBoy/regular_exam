package bg.softuni.regular_exam.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
//    @Scheduled(fixedDelay = 10000)
    //in between the hours of 8am to 8 pm the web app theme will be light
    @Scheduled(cron = "0 8-20 * * * ?")
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        Theme.darkTheme = false; //!Theme.darkTheme;
        System.out.println(Theme.darkTheme);
    }
    //in between the hours of 8pm to 8 am the web app theme will be dark
    @Scheduled( cron="0 20-23,0-7 * * * ?")//
    public void scheduleFixedDelayTask1() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        Theme.darkTheme = true; //!Theme.darkTheme;
        System.out.println(Theme.darkTheme);
    }
}

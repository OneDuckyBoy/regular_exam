package bg.softuni.regular_exam.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    Schedule schedule;
    @BeforeEach
    void before(){
         schedule = new Schedule();
    }
    @Test
    void scheduleFixedDelayTask() {
        schedule.scheduleFixedDelayTask();
        assert true;
    }

    @Test
    void scheduleFixedDelayTask1() {
        schedule.scheduleFixedDelayTask1();
        assert true;
    }
}
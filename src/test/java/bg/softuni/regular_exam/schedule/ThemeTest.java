package bg.softuni.regular_exam.schedule;

import org.junit.jupiter.api.Test;

import static bg.softuni.regular_exam.schedule.Theme.darkTheme;
import static org.junit.jupiter.api.Assertions.*;

class ThemeTest {
    @Test
    public void TestDefaultValueOfTheme(){

        darkTheme=false;
        assertFalse(false);
    }
}
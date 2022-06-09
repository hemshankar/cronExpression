import com.deliveroo.solution.handlers.*;
import com.deliveroo.solution.models.ResultData;
import org.junit.Test;

public class TestExpressions {

    @Test
    public void testMinuteHandler() {
        MinuteHandler minuteHandler = new MinuteHandler();
        ResultData resultData = minuteHandler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60"));
    }

    @Test
    public void testHourHandler() {
        HourHandler handler = new HourHandler();
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24"));
    }

    @Test
    public void testDayHandler() {
        DayHandler handler = new DayHandler();
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31"));
    }

    @Test
    public void testMonthHandler() {
        MonthHandler handler = new MonthHandler();
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12"));
    }

    @Test
    public void testDayOfWeekHandler() {
        DayOfWeekHandler handler = new DayOfWeekHandler();
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7"));
    }
}

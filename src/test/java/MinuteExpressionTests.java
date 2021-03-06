import com.deliveroo.solution.handlers.DayHandler;
import com.deliveroo.solution.handlers.MinuteHandler;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;
import org.junit.Test;

public class MinuteExpressionTests implements ExpressionsTest {
    MinuteHandler handler = new MinuteHandler();

   @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59"));
    }

   @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10"));
    }

   @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
        assert (resultData.value.trim().equals("1 11 21 31 41 51"));
    }

   @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("11");
       resultData.key.equals(TIME_FIELD.MIN);
        assert (resultData.value.trim().equals("11"));
    }
}

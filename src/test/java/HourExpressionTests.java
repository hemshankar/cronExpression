import com.deliveroo.solution.handlers.HourHandler;
import com.deliveroo.solution.handlers.MinuteHandler;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;
import org.junit.Test;

public class HourExpressionTests implements ExpressionsTest {
    HourHandler handler = new HourHandler();

    @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23"));
    }

   @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10"));
    }

   @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
       resultData.key.equals(TIME_FIELD.HOUR);
        assert (resultData.value.trim().equals("1 11 21"));
    }

   @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("11");
       resultData.key.equals(TIME_FIELD.HOUR);
        assert (resultData.value.trim().equals("11"));
    }
}

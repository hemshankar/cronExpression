import com.deliveroo.solution.handlers.DayOfWeekHandler;
import com.deliveroo.solution.handlers.MonthHandler;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;
import org.junit.Test;

public class DayOfWeekExpressionTests implements ExpressionsTest {
    DayOfWeekHandler handler = new DayOfWeekHandler();

    @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        resultData.key.equals(TIME_FIELD.DAY_OF_WEEK);
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6"));
    }

   @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
       resultData.key.equals(TIME_FIELD.DAY_OF_WEEK);
        assert (resultData.value.trim().equals("1 2 3 4 5 6"));
    }

   @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
       resultData.key.equals(TIME_FIELD.DAY_OF_WEEK);
        assert (resultData.value.trim().equals("1"));
    }

    @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("6");
        resultData.key.equals(TIME_FIELD.DAY_OF_WEEK);
        assert (resultData.value.trim().equals("6"));
    }
}

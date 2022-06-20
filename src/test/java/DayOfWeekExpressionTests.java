import com.deliveroo.solution.handlers.DayOfWeekHandler;
import com.deliveroo.solution.handlers.MonthHandler;
import com.deliveroo.solution.models.ResultData;
import org.junit.Test;

public class DayOfWeekExpressionTests implements ExpressionTests{
    DayOfWeekHandler handler = new DayOfWeekHandler();

    @Override @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("0 1 2 3 4 5 6"));
    }

    @Override @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
        assert (resultData.value.trim().equals("1 2 3 4 5 6"));
    }

    @Override @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
        assert (resultData.value.trim().equals("1"));
    }

    @Override @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("6");
        assert (resultData.value.trim().equals("6"));
    }
}

import com.deliveroo.solution.handlers.HourHandler;
import com.deliveroo.solution.handlers.MonthHandler;
import com.deliveroo.solution.models.ResultData;
import org.junit.Test;

public class MonthExpressionTests implements ExpressionTests{
    MonthHandler handler = new MonthHandler();

    @Override @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10 11 12"));
    }

    @Override @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10"));
    }

    @Override @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
        assert (resultData.value.trim().equals("1 11"));
    }

    @Override @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("11");
        assert (resultData.value.trim().equals("11"));
    }
}

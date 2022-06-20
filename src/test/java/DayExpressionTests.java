import com.deliveroo.solution.handlers.DayHandler;
import com.deliveroo.solution.models.ResultData;
import org.junit.Test;

public class DayExpressionTests{
    DayHandler handler = new DayHandler();

    @Test
    public void testWildCard() {
        ResultData resultData = handler.handle("*");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31"));
    }

    @Test
    public void testRange() {
        ResultData resultData = handler.handle("1-10");
        assert (resultData.value.trim().equals("1 2 3 4 5 6 7 8 9 10"));
    }

    @Test
    public void testInterval() {
        ResultData resultData = handler.handle("1/10");
        assert (resultData.value.trim().equals("1 11 21 31"));
    }

    @Test
    public void testSingleValue() {
        ResultData resultData = handler.handle("11");
        assert (resultData.value.trim().equals("11"));
    }
}

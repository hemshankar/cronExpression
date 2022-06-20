import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({DayExpressionTests.class, DayOfWeekExpressionTests.class, MinuteExpressionTests.class, HourExpressionTests.class, MonthExpressionTests.class})
public class TestExpressions {

    @Test
    public void test(){
        assert(true);
    }

}

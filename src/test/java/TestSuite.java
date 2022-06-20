import com.deliveroo.solution.Solution;
import com.deliveroo.solution.models.ResultData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.List;

@RunWith(Suite.class)
@Suite.SuiteClasses({DayExpressionTests.class, DayOfWeekExpressionTests.class, MinuteExpressionTests.class, HourExpressionTests.class, MonthExpressionTests.class})
public class TestSuite {

    @Test
    public void test(){
        String res = "month           1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "day of week     1 2 3 4 5\n" +
                "minute          0 15 30 45\n" +
                "command         /usr/bin/find\n" +
                "hour            0\n" +
                "day of month    1 15\n";
        String [] args = {"*/15 0 1,15 * 1-5 /usr/bin/find"};
        Solution solution = new Solution();
        List<ResultData> resData = solution.solve(args);
        String [] resArray = res.split("\n");

        int i = 0;
        for(String str : resArray){
            Assert.assertEquals(str, resData.get(i++));
        }
    }

}

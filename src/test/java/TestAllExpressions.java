import com.deliveroo.solution.Solution;
import com.deliveroo.solution.models.ResultData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestAllExpressions {

    @Test
    public void test1(){
        String res =
                "minute      \t5\n" +
                "hour        \t5\n" +
                "day of month\t5\n" +
                "month        \t5\n" +
                "day of week \t5\n" +
                "command      \t/usr/bin/find";
        String [] args = "5 5 5 5 5 /usr/bin/find".split(" ");

        Solution solution = new Solution();
        List<ResultData> resData = solution.solve(args);
        String [] resArray = res.split("\n");

        int i = 0;
        for(String str : resArray){
            Assert.assertEquals(str, resData.get(i++).toString());
        }
    }

    @Test
    public void test2(){

    }
}

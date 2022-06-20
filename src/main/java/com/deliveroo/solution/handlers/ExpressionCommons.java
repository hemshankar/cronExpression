package com.deliveroo.solution.handlers;

import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class ExpressionCommons {
    ResultData resultData = new ResultData();
    Integer first;
    Integer last;

    public ExpressionCommons(Integer first_, Integer last_){
        first = first_;
        last = last_;
    }

    public ResultData handle(String key, String s){
        resultData.key = key;
        try {
            if ("*".equals(s)) {
                resultData.value = IntStream.rangeClosed(first, last).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else if (s.contains(",")) {
                String[] arr = s.split(",");
                for (String str : arr) {
                    int i = Integer.parseInt(str);
                    if(i < first || i > last) throw new Exception();
                    resultData.value = resultData.value + str + " ";
                }
                resultData.value = resultData.value.trim();
            } else if (s.contains("-")) {
                String[] arr = s.split("-");
                resultData.value = IntStream.rangeClosed(Integer.parseInt(arr[0]), Math.min(Integer.parseInt(arr[1]),last)).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else if (s.contains("/")) {
                String[] arr = s.split("/");
                Integer start = first;
                if (!"*".equals(arr[0])) {
                    start = Integer.parseInt(arr[0]);
                }
                Integer interval = Integer.parseInt(arr[1]);
                Integer limit = last / interval + 1;
                resultData.value = IntStream.iterate(start, i -> i + interval).limit(limit).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else {

                Integer i = Integer.parseInt(s);
                if (i >= first && i <= last)
                    resultData.value = s;
                else {
                    resultData.value = "Invalid";
                }
            }
        }catch(Exception e) {
            resultData.value = "Invalid";
        }

        resultData.value = resultData.value.trim();
        return resultData;
    }

}

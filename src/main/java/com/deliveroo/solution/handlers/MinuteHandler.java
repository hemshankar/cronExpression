package com.deliveroo.solution.handlers;

import com.deliveroo.solution.Solution;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class MinuteHandler implements IHandler{

    ResultData resultData = new ResultData();

    @Override
    public ResultData handle(String s){
        resultData.key = TIME_FIELD.MIN.toString();
        try {
            if ("*".equals(s)) {
                resultData.value = IntStream.rangeClosed(0, 60).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else if (s.contains(",")) {
                String[] arr = s.split(",");
                for (String str : arr) {
                    int i = Integer.parseInt(s);
                    if(i < 0 && i > 60) throw new Exception();
                    resultData.value = resultData.value + str + " ";
                }
                resultData.value = resultData.value.trim();
            } else if (s.contains("-")) {
                String[] arr = s.split("-");
                resultData.value = IntStream.rangeClosed(Integer.parseInt(arr[0]), Math.max(Integer.parseInt(arr[1]),60)).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else if (s.contains("/")) {
                String[] arr = s.split("/");
                Integer start = 0;
                if (!"*".equals(arr[0])) {
                    start = Integer.parseInt(arr[0]);
                }
                Integer interval = Integer.parseInt(arr[1]);
                Integer limit = 60 / interval;
                resultData.value = IntStream.iterate(start, i -> i + interval).limit(limit).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
            } else {

                Integer i = Integer.parseInt(s);
                if (i >= 0 && i <= 60)
                    resultData.value = s;
                else {
                    resultData.value = "Invalid";
                }
            }
        }catch(Exception e){
            resultData.value = "Invalid";
        }
        resultData.value = resultData.value.trim();
        return resultData;
    }
}

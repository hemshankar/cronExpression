package com.deliveroo.solution.handlers;

import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class DayHandler implements IHandler{
    ResultData resultData = new ResultData();

    @Override
    public ResultData handle(String s){
        resultData.key = TIME_FIELD.DAY.toString();
        if("*".equals(s)){
            resultData.value = IntStream.rangeClosed(0, 31).boxed().map(x -> x + "").reduce("", (x, y) -> x + " " + y);
        }else if(s.contains(",")){
            String [] arr = s.split(",");
            for(String str: arr) {
                resultData.value = resultData.value + str + " ";
            }
            resultData.value = resultData.value.trim();
        }else if(s.contains("-")){
            String [] arr = s.split("-");
            resultData.value = IntStream.rangeClosed(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])).boxed().map(x -> x + "").reduce("", (x,y) -> x + " " + y);
        }else if(s.contains("/")){
            String [] arr = s.split("/");
            Integer start = 0;
            if(!"*".equals(arr[0])){
                start = Integer.parseInt(arr[0]);
            }
            Integer interval = Integer.parseInt(arr[1]);
            Integer limit = 31/interval;
            resultData.value = IntStream.iterate(start, i -> i + interval).limit(limit).boxed().map(x -> x + "").reduce("", (x,y) -> x + " " + y);
        }
        return resultData;
    }
}

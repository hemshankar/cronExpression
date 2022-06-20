package com.deliveroo.solution.handlers;

import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class DayHandler implements IHandler{
    ResultData resultData = new ResultData();
    ExpressionCommons expressionCommons = new ExpressionCommons(1,31);

    @Override
    public ResultData handle(String s){
        resultData = expressionCommons.handle(TIME_FIELD.DAY.toString(), s);
        return resultData;
    }
}

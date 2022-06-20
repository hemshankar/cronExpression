package com.deliveroo.solution.handlers;

import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class MonthHandler implements IHandler{
    ResultData resultData = new ResultData();
    ExpressionCommons expressionCommons = new ExpressionCommons(1,12);
    @Override
    public ResultData handle(String s){
        resultData = expressionCommons.handle(s);
        return resultData;
    }
}

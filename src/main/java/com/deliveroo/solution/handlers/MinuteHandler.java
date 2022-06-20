package com.deliveroo.solution.handlers;

import com.deliveroo.solution.Solution;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.stream.IntStream;

public class MinuteHandler implements IHandler{

    ResultData resultData = new ResultData();
    ExpressionCommons expressionCommons = new ExpressionCommons(0,59);
    @Override
    public ResultData handle(String s){

        resultData = expressionCommons.handle(TIME_FIELD.MIN.toString(),s);
        return resultData;
    }
}

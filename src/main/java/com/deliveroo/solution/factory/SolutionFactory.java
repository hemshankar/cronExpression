package com.deliveroo.solution.factory;

import com.deliveroo.solution.Solution;
import com.deliveroo.solution.handlers.IHandler;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.HashMap;
import java.util.Map;

public class SolutionFactory {
    private SolutionFactory(){}
    private static SolutionFactory solutionFactory = new SolutionFactory();
    private Map<TIME_FIELD, IHandler> handlerMap = new HashMap<>();
    public static SolutionFactory get(){
        return solutionFactory;
    }

    public IHandler getHandler(TIME_FIELD field){
        return handlerMap.get(field);
    }

    public boolean register(TIME_FIELD field, IHandler handler){
        if(!handlerMap.containsKey(field)){
            handlerMap.put(field, handler);
            return true;
        }
        return false;
    }
}

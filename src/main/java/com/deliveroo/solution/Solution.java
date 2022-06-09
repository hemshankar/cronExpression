package com.deliveroo.solution;

import com.deliveroo.solution.factory.HandlerManager;
import com.deliveroo.solution.factory.SolutionFactory;
import com.deliveroo.solution.handlers.HourHandler;
import com.deliveroo.solution.handlers.MinuteHandler;
import com.deliveroo.solution.models.ResultData;
import com.deliveroo.solution.models.TIME_FIELD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        args = args[0].split(" ");
        solution.solve(args);
    }

    public void solve(String [] args){

        if(args.length < 6){
            System.err.println("Invalid Input!");
            System.out.println("Usage MIN, HOUR, DAY, MONTH, DAY_OF_WEEK CMD");
            System.out.println("eg */15 0 1,15 * 1-5 /usr/bin/find");
            return;
        }

        HandlerManager.registerHandlers();

        List<ResultData> result = new ArrayList<>();
        int i=0;
        for(TIME_FIELD tf : TIME_FIELD.values()){
            String arg = args[i++];
            result.add(SolutionFactory.get().getHandler(tf).handle(arg));
        }
        ResultData cmd = new ResultData();
        cmd.key = "command      ";
        cmd.value = args[i];
        result.add(cmd);
        result.forEach(x -> System.out.println(x));

        System.out.println("\n\n\nNOTE: Following are not supported yet -> L, W, #, ?, MON, TUE, WED, THU, FRI, SAT, SUN");
    }
}

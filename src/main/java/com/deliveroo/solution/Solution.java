package com.deliveroo.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    /*
     * * (all) specifies that event should happen for every time unit. For example, “*” in the <minute> field means “for every minute.”
     * ? (any) is utilized in the <day-of-month> and <day-of -week> fields to denote the arbitrary value and thus neglect the field value. For example, if we want to fire a script at “5th of every month” irrespective of what day of the week falls on that date, we specify a “?” in the <day-of-week> field.
     * – (range) determines the value range. For example, “10-11” in the <hour> field means “10th and 11th hours.”
     * , (values) specifies multiple values. For example, “MON, WED, FRI“ in <day-of-week> field means on the days “Monday, Wednesday and Friday.”
     * / (increments) specifies the incremental values. For example, a “5/15” in the <minute> field means at “5, 20, 35 and 50 minutes of an hour.”
     * L (last) has different meanings when used in various fields. For example, if it's applied in the <day-of-month> field, it means last day of the month, i.e. “31st of January” and so on as per the calendar month. It can be used with an offset value, like “L-3”, which denotes the “third to last day of the calendar month.” In <day-of-week>, it specifies the “last day of a week.” It can also be used with another value in <day-of-week>, like “6L”, which denotes the “last Friday.”
     * W (weekday) determines the weekday (Monday to Friday) nearest to a given day of the month. For example, if we specify “10W” in the <day-of-month> field, it means the “weekday near to 10th of that month.” So if “10th” is a Saturday, the job will be triggered on “9th,” and if “10th” is a Sunday, it will trigger on “11th.” If we specify “1W” in <day-of-month> and if “1st” is Saturday, the job will be triggered on “3rd,” which is Monday, and it will not jump back to the previous month.
     * # specifies the “N-th” occurrence of a weekday of the month, for example, “third Friday of the month” can be indicated as “6#3”.
     */


    //your-program ＂*/15 0 1,15 * 1-5 /usr/bin/find＂



    /*
    minute 0 15 30 45
    hour 0
    day of month 1 15
    month 1 2 3 4 5 6 7 8 9 10 11 12
    day of week 1 2 3 4 5
    command /usr/bin/find
     */
    //split based on white spaces str.split("\\s+");

    //pass each item to a handler
    public static void main(String[] args) {
        //com.deliveroo.solution.Solution solution = new com.deliveroo.solution.Solution();
        //solution.solve(args);
        MinuteHandler handler = new MinuteHandler();
        ResultData resultData = handler.handle("5-15");
        System.out.println(resultData);
    }

    public enum TIME_FIELD {
        MIN ("minute"),
        HOUR("hour"),
        DAY ("day of month"),
        MONTH ("month"),
        DAY_OF_WEEK("day of week");

        private final String name;
        private TIME_FIELD(String name_) {
            name = name_;
        }
        public String toString() {
            return this.name;
        }
    }

    public interface IHandler {
        public ResultData handle(String s);
    }

    public static class MinuteHandler implements IHandler{

        ResultData resultData = new ResultData();
        public ResultData handle(String s){
            resultData.key = TIME_FIELD.MIN.toString();
            if("*".equals(s)){
                resultData.value = IntStream.rangeClosed(0, 60).boxed().map(x -> x + "").reduce("", (x,y) -> x + " " + y);
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
                Integer limit = 60/interval;
                resultData.value = IntStream.iterate(start, i -> i + interval).limit(limit).boxed().map(x -> x + "").reduce("", (x,y) -> x + " " + y);
            }
            return resultData;
        }
    }

    public class HourHandler implements IHandler{
        public ResultData handle(String s){
            return null;
        }
    }

    public class DayHandler implements IHandler{
        public ResultData handle(String s){
            return null;
        }
    }

    public class MonthHandler implements IHandler{
        public ResultData handle(String s){
            return null;
        }
    }

    public class DayOFWeekHandler implements IHandler{
        public ResultData handle(String s){
            return null;
        }
    }

    public class SolutionFactory {
        private SolutionFactory(){}
        private SolutionFactory solutionFactory = new SolutionFactory();
        private Map<TIME_FIELD, IHandler> handlerMap = new HashMap<>();
        public SolutionFactory get(){
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

    public void solve(String [] args){

        if(args.length < 6){
            System.err.println("Invalid Input!");
            System.out.println("Usage MIN, HOUR, DAY, MONTH, DAY_OF_WEEK CMD");
            System.out.println("eg */15 0 1,15 * 1-5 /usr/bin/find");
        }


        List<ResultData> result = new ArrayList<>();
        int i = 0;
        /*SolutionFactory solutionFactory = SolutionFactory.get();
        for(TIME_FIELD tf : TIME_FIELD.values()){
            result.add(solutionFactory.getHandler(tf).handle(args[i++]));
        }*/

        result.forEach(x -> System.out.println(x));

    }

    static class ResultData{
        String key = "";
        String value = "";

        public String toString(){
            return key + "\t\t\t" + value;
        }
    }
}

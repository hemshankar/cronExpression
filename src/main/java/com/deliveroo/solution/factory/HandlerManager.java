package com.deliveroo.solution.factory;

import com.deliveroo.solution.handlers.*;
import com.deliveroo.solution.models.TIME_FIELD;

public class HandlerManager {

    public static void registerHandlers() {
        SolutionFactory.get().register(TIME_FIELD.MIN, new MinuteHandler());
        SolutionFactory.get().register(TIME_FIELD.HOUR, new HourHandler());
        SolutionFactory.get().register(TIME_FIELD.DAY, new DayHandler());
        SolutionFactory.get().register(TIME_FIELD.MONTH, new MonthHandler());
        SolutionFactory.get().register(TIME_FIELD.DAY_OF_WEEK, new DayOfWeekHandler());
    }

}

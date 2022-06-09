import com.cronutils.mapper.CronMapper;
import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;

import static com.cronutils.model.CronType.QUARTZ;

public class TestExpressions {

    public static void main(String[] args) {

        CronDefinition cronDefinition =
                CronDefinitionBuilder.defineCron()
                        .withSeconds().and()
                        .withMinutes().and()
                        .withHours().and()
                        .withDayOfMonth()
                        .supportsHash().supportsL().supportsW().and()
                        .withMonth().and()
                        .withDayOfWeek()
                        .withIntMapping(7, 0) //we support non-standard non-zero-based numbers!
                        .supportsHash().supportsL().supportsW().and()
                        .withYear().optional().and()
                        .instance();

// or get a predefined instance
        cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(QUARTZ);


        // Turn cron expressions into another format by using CronMapper:

        CronMapper cronMapper = CronMapper.fromUnixToQuartz();
        CronParser parser = new CronParser(cronDefinition);
        Cron quartzCron = parser.parse("0 25 * ? * 1-5 *");

        //Cron quartzCron = cronMapper.map(unixCron);
        // and to get a String representation of it, we can use

        quartzCron.asString();

        //validate the cron expression!
        quartzCron.validate();
    }

}

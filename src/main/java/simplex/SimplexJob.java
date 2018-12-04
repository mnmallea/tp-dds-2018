package simplex;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimplexJob {

    private static final int INTERVAL_IN_SECONDS = 1800;

    public static void init() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(INTERVAL_IN_SECONDS).repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}

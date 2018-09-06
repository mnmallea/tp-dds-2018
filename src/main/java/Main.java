import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import repositorios.QuartzJob;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(QuartzJob.class).build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1800).repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}

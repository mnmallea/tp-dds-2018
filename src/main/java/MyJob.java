import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Soy un job");
    }
}

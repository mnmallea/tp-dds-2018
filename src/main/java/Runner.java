import org.quartz.SchedulerException;
import simplex.SimplexJob;
import spark.Spark;
import spark.debug.DebugScreen;

public class Runner {
    public static void main(String[] args) throws SchedulerException {
        SimplexJob.init();
        Spark.port(9000);
        DebugScreen.enableDebugScreen();
        Routes.configure();
    }
}

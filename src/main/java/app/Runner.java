import org.quartz.SchedulerException;

import simplex.SimplexJob;
import spark.Spark;
import spark.debug.DebugScreen;

public class Runner {
    public static void main(String[] args) throws SchedulerException {
//        SimplexJob.init();
        //TODO HACER PK LONG DE REPOUSUARIOS
        Spark.ipAddress("0.0.0.0");
        int port;
        try {
            port = Integer.valueOf(args[0]);
        } catch (Exception e) {
            port = 9000;
            DebugScreen.enableDebugScreen();
        }
        Spark.port(port);
        Routes.configure();
    }
}

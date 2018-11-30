import app.Routes;
import org.quartz.SchedulerException;
import spark.Spark;
import spark.debug.DebugScreen;

import static spark.Spark.secure;

public class Runner {
    public static void main(String[] args) throws SchedulerException {
//        SimplexJob.init();
        //TODO HACER PK LONG DE REPOUSUARIOS
        Spark.ipAddress("0.0.0.0");
        int port;
        try {
            port = Integer.valueOf(args[0]);
            if (port == 443) {
                secure("deploy/clientcert.jks", "thepass", null, null);
            }
        } catch (Exception e) {
            port = 9000;
            DebugScreen.enableDebugScreen();
        }
        Spark.port(port);
        Routes.configure();
    }
}

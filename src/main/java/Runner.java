import spark.Spark;
import spark.debug.DebugScreen;

public class Runner {
    public static void main(String[] args) {
        Spark.port(9000);
        DebugScreen.enableDebugScreen();
        Routes.configure();
    }
}

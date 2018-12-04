package simplex;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import repositorios.AdministradorClientes;

public class QuartzJob implements Job, WithGlobalEntityManager, TransactionalOps {
    private static final Logger logger = LoggerFactory.getLogger(QuartzJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        logger.info("Ejecutando simplex...");
        withTransaction(AdministradorClientes.instancia::simplexarClientes);
    }
}

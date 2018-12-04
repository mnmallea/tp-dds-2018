package simplex;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import repositorios.AdministradorClientes;

public class QuartzJob implements Job, WithGlobalEntityManager, TransactionalOps {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        withTransaction(AdministradorClientes.instancia::simplexarClientes);
        System.out.println("Simplexando clientes");
    }
}

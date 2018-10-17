package simplex;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import repositorios.AdministradorClientes;

public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        AdministradorClientes.instancia.simplexarClientes();
        System.out.println("Simplexando clientes");
    }
}

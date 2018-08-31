package repositorios;

import dominio.AdministradorClientes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        AdministradorClientes.instancia.simplexarClientes();
        System.out.println("Simplexando clientes");
    }
}

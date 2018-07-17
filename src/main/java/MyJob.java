import org.quartz.Job;
import org.quartz.JobExecutionContext;
import repositorios.RepoClientes;

public class MyJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        RepoClientes.instancia.simplexarClientes();
        System.out.println("Simplexando clientes");
    }
}

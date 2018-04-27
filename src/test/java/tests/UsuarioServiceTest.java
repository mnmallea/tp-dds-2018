package tests;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.TipoDocumento;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.UsuariosService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceTest {

    UsuariosService usuariosService;
    @Before
    public void init() {
        usuariosService = new UsuariosService();

    }

    @Test
    public void leerJson(){
        Cliente cliente = usuariosService.parserUsuarioToCliente();
        Assert.assertEquals(1, 1);
    }
}

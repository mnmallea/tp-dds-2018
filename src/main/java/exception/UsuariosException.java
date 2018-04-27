package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UsuariosException extends RuntimeException {

    public UsuariosException(String msj, FileNotFoundException ioe) {
        super(msj);
    }
}

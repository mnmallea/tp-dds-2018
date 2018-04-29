package exception;

import java.io.FileNotFoundException;

public class UsuariosException extends RuntimeException {

    public UsuariosException(String msj, FileNotFoundException ioe) {
        super(msj);
    }
}

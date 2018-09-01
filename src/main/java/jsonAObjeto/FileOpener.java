package jsonAObjeto;

import exception.ArchivoNoEncontradoException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOpener {

    public static FileReader abrirArchivo(String file) {
        try {
            return new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException("El archivo no existe");
        }
    }

}

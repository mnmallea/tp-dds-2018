package jsonAObjeto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import exception.ArchivoNoEncontradoException;

public class FileOpener {

	public static FileReader abrirArchivo(String file) {
		try {
			return new FileReader(file);
		}
		catch (FileNotFoundException e) {
			throw new ArchivoNoEncontradoException("El archivo no existe");
		}
	}

}

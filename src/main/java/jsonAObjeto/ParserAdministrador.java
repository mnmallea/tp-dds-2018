package jsonAObjeto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dominio.Administrador;
import exception.ParserException;

import java.io.Reader;
import java.time.LocalDate;

public class ParserAdministrador {

    public static Administrador[] obtenerAdministradores(String file) {
        Administrador[] administradores;
        Reader reader = FileOpener.abrirArchivo(file);
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateDeserializer()).create();
        try {
            administradores = gson.fromJson(reader, Administrador[].class);
        } catch (RuntimeException e) {
            throw new ParserException(e);
        }
        return administradores;
    }
}

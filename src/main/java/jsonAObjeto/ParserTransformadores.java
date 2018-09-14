package jsonAObjeto;

import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dominio.Transformador;
import dominio.Zona;
import exception.ParserException;

public class ParserTransformadores {

    public static Transformador[] obtenerTransformadores(String file) {
        Transformador[] transformadores;
        Reader reader = FileOpener.abrirArchivo(file);
        Gson gson = new GsonBuilder().registerTypeAdapter(Zona.class, new ZonaDeserializer()).create();
        try {
            transformadores = gson.fromJson(reader, Transformador[].class);
        } catch (RuntimeException e) {
            throw new ParserException(e);
        }
        return transformadores;
    }
}

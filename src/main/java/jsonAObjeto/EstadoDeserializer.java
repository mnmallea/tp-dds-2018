package jsonAObjeto;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import dominio.estados.AhorroEnergia;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import dominio.estados.Estado;
import exception.ParserException;

import java.lang.reflect.Type;

public class EstadoDeserializer implements JsonDeserializer<Estado> {

    private static final String AHORRO_ENERGIA = "AhorroEnergia";
    private static final String ENCENDIDO = "Encendido";
    private static final String APAGADO = "Apagado";

    @Override
    public Estado deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        String parsed = json.getAsString();
        if (parsed.equals(AHORRO_ENERGIA)) {
            return new AhorroEnergia();
        }
        if (parsed.equals(ENCENDIDO)) {
            return new Encendido();
        }
        if (parsed.equals(APAGADO)) {
            return new Apagado();
        }
        throw new ParserException("Estado invalido");
    }

}

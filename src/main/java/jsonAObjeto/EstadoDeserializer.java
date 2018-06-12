package jsonAObjeto;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import dominio.AhorroEnergia;
import dominio.Apagado;
import dominio.Encendido;
import dominio.Estado;
import exception.ParserException;

public class EstadoDeserializer implements JsonDeserializer<Estado> {

	@Override
	public Estado deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		String parsed = json.getAsString();
		if(parsed.equals("AhorroEnergia")) {
			return new AhorroEnergia();
		}
		if(parsed.equals("Encendido")) {
			return new Encendido();
		}
		if(parsed.equals("Apagado")) {
			return new Apagado();
		}
		throw new ParserException("Estado invalido");
	}
	
}

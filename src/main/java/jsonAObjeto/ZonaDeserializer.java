package jsonAObjeto;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import dominio.Zona;
import dominio.estados.AhorroEnergia;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import exception.ParserException;
import repositorios.RepoZonas;

public class ZonaDeserializer implements JsonDeserializer<Zona> {

	@Override
	public Zona deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Long parsed = json.getAsLong();
		Zona zona = RepoZonas.instance.getZonaPorID(parsed);
		return zona;
	}

}

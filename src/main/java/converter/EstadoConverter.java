package converter;

import dominio.estados.AhorroEnergia;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import dominio.estados.Estado;

import javax.persistence.AttributeConverter;

public class EstadoConverter implements AttributeConverter<Estado, String> {

    private static final String AHORRO_ENERGIA = "Ahorro_Energia";
    private static final String APAGADO = "Apagado";
    private static final String ENCENDIDO = "Encendido";

    @Override
    public String convertToDatabaseColumn(Estado attribute) {
        if (attribute instanceof AhorroEnergia)
            return AHORRO_ENERGIA;
        if (attribute instanceof Apagado)
            return APAGADO;
        if (attribute instanceof Encendido)
            return ENCENDIDO;
        throw new RuntimeException();
    }

    @Override
    public Estado convertToEntityAttribute(String dbData) {
        if (dbData.equals(AHORRO_ENERGIA))
            return new AhorroEnergia();
        if (dbData.equals(APAGADO))
            return new Apagado();
        if (dbData.equals(ENCENDIDO))
            return new Encendido();
        throw new RuntimeException();
    }
}

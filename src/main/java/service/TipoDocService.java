package service;

import dominio.TipoDocumento;
import exception.TipoDeDocumentoException;
import org.apache.commons.lang3.EnumUtils;

import java.util.HashMap;
import java.util.Map;

public class TipoDocService {

    private static TipoDocService instance ;
    private Map<String, TipoDocumento> parser = new HashMap<>();

    public static TipoDocService getInstance(){

        if(instance == null) {
            instance = new TipoDocService();
            instance.refillHashMap();
        }
        return instance;
    }

    private TipoDocService(){
        refillHashMap();
    }

    public void refillHashMap(){
        parser.put("CI", TipoDocumento.CI);
        parser.put("DNI", TipoDocumento.DNI);
        parser.put("LC", TipoDocumento.LC);
        parser.put("LE", TipoDocumento.LE);
    }

    public TipoDocumento parserToDocumentType(String tipoDocumento) {
        tipoDocumento = tipoDocumento.toUpperCase();
        if(EnumUtils.isValidEnum(TipoDocumento.class, tipoDocumento)) {
            return parser.get(tipoDocumento);
        }
        else{
            throw new TipoDeDocumentoException("No existe el tipo de documento");
        }
    }

}
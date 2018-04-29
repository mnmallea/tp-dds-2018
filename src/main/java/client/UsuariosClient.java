package client;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dto.UsuarioDTO;

public class UsuariosClient {

    ObjectMapper jsonMapper = new ObjectMapper();
    //Clase que me obtiene el json
    public UsuarioDTO obtenerUsuarios(String file) {
        //usuarios = jsonMapper.readValue(new File(file), UsuarioDTO.class);
        UsuarioDTO usuarios=null;

        try (Reader reader = new FileReader(file)) {

            Gson gson = new Gson();
            usuarios = gson.fromJson(reader, UsuarioDTO.class);
            return usuarios;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}

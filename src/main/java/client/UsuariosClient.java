package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dominio.Cliente;
import dto.UsuarioDTO;
import exception.UsuariosException;
import utils.Mapper;

import java.io.*;
import java.util.List;

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

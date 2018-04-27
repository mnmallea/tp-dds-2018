package service;

import client.UsuariosClient;
import dominio.*;
import dto.DispositivoDto;
import dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class UsuariosService {

    private TipoDocService tipoDocService = TipoDocService.getInstance();
    private UsuariosClient usuariosClient = new UsuariosClient();

    public Cliente parserUsuarioToCliente(){

        UsuarioDTO usuarioDTO = usuariosClient.obtenerUsuarios("src/main/resources/modeljson.json");

        TipoDocumento tipoDoc = tipoDocService.parserToDocumentType(usuarioDTO.getTipoDocumento());

        Cliente cliente = new Cliente(usuarioDTO.getNombre(), usuarioDTO.getApellido(), tipoDoc, usuarioDTO.getNroDocumento(), usuarioDTO.getNroTelefono(), usuarioDTO.getDomicilio(), Categorizador.getInstanceOf().getCategoriaSegunRango(usuarioDTO.getConsumo()), this.parserDispositivo(usuarioDTO.getDispositivosDto()));

        return cliente;
    }

    private List<Dispositivo> parserDispositivo(List<DispositivoDto> dispositivosDto) {
        List<Dispositivo> dispositivosList = new ArrayList<>();
        for(DispositivoDto dispositivoDto: dispositivosDto){

            Dispositivo dispositivo = new Dispositivo(dispositivoDto.getNombre(), dispositivoDto.getConsumoPorHora());
            dispositivo.setEncendido(dispositivoDto.getEncendido());
            dispositivosList.add(dispositivo);
        }
        return dispositivosList;
    }
}


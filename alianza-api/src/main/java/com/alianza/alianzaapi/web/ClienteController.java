package com.alianza.alianzaapi.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.alianzaapi.dto.ClienteDTO;
import com.alianza.alianzaapi.dto.ResultDTO;
import com.alianza.alianzaapi.services.ICliente;


@RestController
@RequestMapping("/api")
public class ClienteController {

	private static final Logger logger = Logger.getLogger(ClienteDTO.class.getName());
	
	@Autowired
	private ICliente clienteService;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> buscarTodos() {
		
		List<ClienteDTO> lclientes = clienteService.getDataInicial();
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(lclientes);
		
	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<List<ClienteDTO>> buscarPorId(@PathVariable("id") String idCliente) {
		List<ClienteDTO> lclientes  =  clienteService.buscarPorId(idCliente);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(lclientes);
	}
	
	@PostMapping("clientes")
	public ResponseEntity<ResultDTO> guardar(@RequestBody ClienteDTO pCliente) {
		ResultDTO resultDTO=new ResultDTO();
	   try {
			boolean existe = clienteService.buscarPorCorreo(pCliente.getEmail());
			
			if(existe) {
				resultDTO.setMsgRespuesta("Cliente Existe");
				resultDTO.setLcliente(new ArrayList<ClienteDTO>());
			}else {
				resultDTO.setMsgRespuesta("Cliente Guardado");
				resultDTO.setLcliente(clienteService.adicionarCliente(pCliente));
			}
	   }catch(Exception e) {
			logger.log(Level.ERROR, e.getMessage());
	   }
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(resultDTO);

	}

}

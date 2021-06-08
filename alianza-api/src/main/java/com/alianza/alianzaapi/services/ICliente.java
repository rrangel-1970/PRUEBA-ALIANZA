package com.alianza.alianzaapi.services;

import java.util.List;

import com.alianza.alianzaapi.dto.ClienteDTO;

public interface ICliente {
	List<ClienteDTO> getDataInicial();
	
	List<ClienteDTO> buscarPorId(String pId);
	
	List<ClienteDTO> adicionarCliente(ClienteDTO pCliente);
	
	public boolean buscarPorCorreo(String pEmail);
}

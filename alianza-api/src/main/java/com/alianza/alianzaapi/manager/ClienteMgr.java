package com.alianza.alianzaapi.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.alianza.alianzaapi.dto.ClienteDTO;
import com.alianza.alianzaapi.services.ICliente;

@Service
public class ClienteMgr implements ICliente {
	
	private static final Logger logger = Logger.getLogger(ClienteDTO.class.getName());


	@Override
	public List<ClienteDTO> getDataInicial() {
		
        ClienteDTO clienteDTO = new ClienteDTO();
		return this.getObtenerListaClientes();
	}

	@Override
	public List<ClienteDTO> buscarPorId(String pId) {
		List<ClienteDTO> lclientes = new ArrayList<ClienteDTO>();
		
		try {
	        ClienteDTO cliente = new ClienteDTO();
			cliente = this.obtenerCliente(pId);
			lclientes.add(cliente);
		}catch(Exception e) {
			logger.log(Level.ERROR, e.getMessage());
		}
		return lclientes;
	}

	@Override
	public List<ClienteDTO> adicionarCliente(ClienteDTO pCliente) {
		List<ClienteDTO> lclientes = new ArrayList<ClienteDTO>();
		
		try {
	        ClienteDTO clienteDTO = new ClienteDTO();
			lclientes = this.getDataInicial();
			lclientes.add(poblarCliente(null, pCliente.getName(), pCliente.getPhone(), pCliente.getEmail(),
					                 pCliente.getStarDate(), pCliente.getEndDate()));
			
		}catch(Exception e) {
			logger.log(Level.ERROR, e.getMessage());
		}
		
		return lclientes;
	}
	
	@Override
	public boolean buscarPorCorreo(String pEmail) {
		boolean result = false;
       
		try {
	        ClienteDTO clienteDTO = new ClienteDTO();
			List<ClienteDTO> lclientes = getDataInicial();
			for(ClienteDTO clt :lclientes) {
				if(pEmail.equals(clt.getEmail())) {
					result = true;
				}
			}
		}catch (Exception e){
			logger.log(Level.ERROR, e.getMessage());
		}
		
		return result;
	}
	
	
	
	public List<ClienteDTO> getObtenerListaClientes(){
		List<ClienteDTO> lcliente = new ArrayList<ClienteDTO>();
		
		String strFechaInicio = "20/05/2019";
		Date fechaInicio;
		try {
			fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(strFechaInicio);
			lcliente.add(poblarCliente("jgutierrez","Juliana Gutierrez","3219876543","jgutierrez@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("mmartinez","Manuel Martinez","3219876543","mmartinez@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("aruiz","Ana Ruiz","3219876543","aruiz@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("ogarcia","Oscar Garcia","3219876543","ogarcia@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("tramos","Tania Ramos","3219876543","tramos@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("cariza","Carlos Ariza","3219876543","cariza@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("rvillaneda","Rodrigo Villaneda","3219876543","rvillaneda@gmail.com",fechaInicio ,null));
			lcliente.add(poblarCliente("mfonseca","Mauricio Fonseca","3219876543","mfonseca@gmail.com",fechaInicio ,null));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.log(Level.ERROR, e.getMessage());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			logger.log(Level.ERROR, e.getMessage());
		}
		
        return lcliente;		
	}
	
	

	public ClienteDTO poblarCliente(String pId, String pName, String pPhone, String pEmail, Date pStartDate , Date pEndDate) {
		ClienteDTO cliente = new ClienteDTO();
		
		try {
		
				if(pName != null) {
					
					if (pId == null) {
						String[] arrNombre = pName.split(" ");
						if(arrNombre.length > 1) {
							pId = arrNombre[0].substring(0,1)+arrNombre[1];
						}else {
							pId = arrNombre[0];
						}
					}
		
					cliente.setName(pName);
					cliente.setPhone(pPhone);
					cliente.setEmail(pEmail);
					cliente.setStarDate(pStartDate);
					cliente.setEndDate(pEndDate);
					cliente.setId(pId);
				}

		}catch(Exception e) {
			logger.log(Level.ERROR, e.getMessage());
		}
		return cliente;
		
	}
	
	public ClienteDTO obtenerCliente(String id){
		ClienteDTO clienteDTO = null;
		
	 try {
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		clientes = this.getDataInicial();
		for(ClienteDTO clt : clientes) {
			if(id.equals(clt.getId())) {
				clienteDTO = clt;
				break;
			}
		}
	 }catch(Exception e) {
    	logger.log(Level.ERROR, e.getMessage());
	 }
		
	return clienteDTO;
	}

}


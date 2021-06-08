package com.alianza.alianzaapi.dto;

import java.util.List;

public class ResultDTO {
	
	private String msgRespuesta;
	
	private List<ClienteDTO> lcliente;

	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}

	public List<ClienteDTO> getLcliente() {
		return lcliente;
	}

	public void setLcliente(List<ClienteDTO> lcliente) {
		this.lcliente = lcliente;
	}
	
}

package br.com.tenax.api.tenax.dto;

import br.com.tenax.api.tenax.domain.Servidor;

public class ServidorRequestDTO {

	private String nomeServidor;
	private String descServidor;

	public ServidorRequestDTO() {
		super();
	}

	public ServidorRequestDTO(String nomeServidor, String descServidor) {
		super();
		this.nomeServidor = nomeServidor;
		this.descServidor = descServidor;
	}

	public ServidorRequestDTO(Servidor servidor) {
		super();
		this.nomeServidor = servidor.getNomeServidor();
		this.descServidor = servidor.getDescServidor();
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public String getDescServidor() {
		return descServidor;
	}

	public void setDescServidor(String descServidor) {
		this.descServidor = descServidor;
	}

}

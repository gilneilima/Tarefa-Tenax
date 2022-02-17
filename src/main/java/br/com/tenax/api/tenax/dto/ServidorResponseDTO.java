package br.com.tenax.api.tenax.dto;

import br.com.tenax.api.tenax.domain.Servidor;

public class ServidorResponseDTO {

	private Long idServidor;
	private String nomeServidor;
	private String descServidor;

	public ServidorResponseDTO() {
		super();
	}

	public ServidorResponseDTO(Servidor servidor) {
		super();
		this.idServidor = servidor.getIdServidor();
		this.nomeServidor = servidor.getNomeServidor();
		this.descServidor = servidor.getDescServidor();
	}
	public ServidorResponseDTO(Long idServidor, String nomeServidor, String descServidor) {
		super();
		this.idServidor = idServidor;
		this.nomeServidor = nomeServidor;
		this.descServidor = descServidor;
	}
	public Long getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(Long idServidor) {
		this.idServidor = idServidor;
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

package br.com.tenax.api.tenax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.tenax.api.tenax.dto.ServidorRequestDTO;
import io.swagger.annotations.ApiModelProperty;

@Table(name = "servidor")
@Entity
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servidor", nullable = false)
	@ApiModelProperty(value = "Identificador único do Servidor")
	private Long idServidor;

	// @NotBlank(message = "Nome do Servidor nao pode ser vazio")
	@Column(name = "nome_servidor")
	@Size(max = 100)
	@ApiModelProperty(value = "Nome do Servidor")
	private String nomeServidor;

	// @NotBlank(message = "Descricao do Servidor nao pode ser vazio")
	@Column(name = "desc_servidor")
	@Size(max = 250)
	@ApiModelProperty(value = "Descricao do Servidor", required = true)
	private String descServidor;

	public Servidor() {
		super();
	}

	public Servidor(Long idServidor, String nomeServidor, String descServidor) {
		super();
		this.idServidor = idServidor;
		this.nomeServidor = nomeServidor;
		this.descServidor = descServidor;
	}

	public Servidor(ServidorRequestDTO servidorRequestDTO) {
		super();
		this.nomeServidor = servidorRequestDTO.getNomeServidor();
		this.descServidor = servidorRequestDTO.getDescServidor();		
	}
	
	public Servidor(Servidor servidor) {
		this.idServidor = servidor.getIdServidor();
		this.nomeServidor = servidor.getNomeServidor();
		this.descServidor = servidor.getDescServidor();
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

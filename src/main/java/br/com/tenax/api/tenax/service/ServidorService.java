package br.com.tenax.api.tenax.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.tenax.api.tenax.domain.Servidor;

public interface ServidorService {

	public Servidor buscar(Long idServidor);

	public Page<Servidor> listar(Pageable pageable);

	public Servidor inserir(Servidor servidor);

	public Servidor atualizar(Long idServidor, Servidor servidor);

	public Servidor deletar(Long idServidor);
	
	public int totalServidor();

}

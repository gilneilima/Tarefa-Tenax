package br.com.tenax.api.tenax.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tenax.api.tenax.domain.Servidor;
import br.com.tenax.api.tenax.dto.ServidorRequestDTO;
import br.com.tenax.api.tenax.dto.ServidorResponseDTO;
import br.com.tenax.api.tenax.service.impl.ServidorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

	@Autowired
	private ServidorServiceImpl servidorServiceImpl;

	@ApiOperation(value = "Listar todos os Servidores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servidores listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<ServidorResponseDTO>> listarTodos(@PageableDefault Pageable pageable) {
		Page<Servidor> servidores = servidorServiceImpl.listar(pageable);
		Page<ServidorResponseDTO> servidorListarDTO = servidores.map(servi -> new ServidorResponseDTO(servi));
		return ResponseEntity.ok(servidorListarDTO);
	}
	
	@ApiOperation(value = "Total de Servidores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Total de Servidores com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/totais")
	public ResponseEntity<Long> totalServidores(@PageableDefault Pageable pageable) {
		Long servidores = (long) servidorServiceImpl.totalServidor();
		return ResponseEntity.ok(servidores);
	}

	@ApiOperation(value = "Buscar um Servidor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servidor encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<ServidorResponseDTO> buscarServidor(@PathVariable("id") Long idServidor) {
		Servidor servidor = servidorServiceImpl.buscar(idServidor);
		if (servidor != null) {
			return ResponseEntity.ok(new ServidorResponseDTO(servidor));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Inserir um Servidor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servidor inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<ServidorResponseDTO> inserirServidor(@RequestBody ServidorRequestDTO servidorRequestDTO) {
		Servidor servi = servidorServiceImpl.inserir(new Servidor(servidorRequestDTO));
		ServidorResponseDTO servidor = new ServidorResponseDTO(servi);
		return ResponseEntity.ok(servidor);
	}

	@ApiOperation(value = "Atualizar um Servidor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servidor atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<ServidorResponseDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody ServidorRequestDTO servidorRequestDTO) {
		Servidor servi = servidorServiceImpl.atualizar(id, new Servidor(servidorRequestDTO));
		if (servi != null) {
			ServidorResponseDTO servidor = new ServidorResponseDTO(servi);
			return ResponseEntity.ok(servidor);
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deletar um Servidor")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Servidor deletado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long idCliente) {

		if (servidorServiceImpl.deletar(idCliente) != null) {
			servidorServiceImpl.deletar(idCliente);

			return ResponseEntity.ok("Servidor apagado");
		}
		return ResponseEntity.notFound().build();

	}

}

package br.com.tenax.api.tenax.service.impl;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.tenax.api.tenax.domain.Servidor;
import br.com.tenax.api.tenax.repository.ServidorRepository;
import br.com.tenax.api.tenax.service.ServidorService;

@Service
public class ServidorServiceImpl implements ServidorService {

	@Autowired
	private ServidorRepository servidorRepository;

	@Override
	public Servidor buscar(Long idServidor) {

		if (servidorRepository.existsById(idServidor)) {
			Optional<Servidor> serv = servidorRepository.findById(idServidor);

			if (serv.isPresent()) {
				return serv.get();
			}
		}

		return null;
	}

	@Override
	public Page<Servidor> listar(Pageable pageable) {
		Page<Servidor> servidorListar = servidorRepository.findAll(pageable);
		return servidorListar;
	}

	@Override
	public int totalServidor() {
		List<Servidor> servidorListar = servidorRepository.findAll();
		return servidorListar.size();
	}

	@Override
	public Servidor inserir(Servidor servidor) {
		Servidor servidorInserir = new Servidor();
		servidorInserir.setNomeServidor(servidor.getNomeServidor());
		servidorInserir.setDescServidor(servidor.getDescServidor());
		servidorRepository.save(servidorInserir);

		return new Servidor(servidorInserir);
	}

	@Override
	public Servidor atualizar(Long idServidor, Servidor servidor) {
		if (servidorRepository.existsById(idServidor)) {
			Servidor servidorAtualizar = new Servidor();
			servidorAtualizar.setIdServidor(idServidor);
			servidorAtualizar.setNomeServidor(servidor.getNomeServidor());
			servidorAtualizar.setDescServidor(servidor.getDescServidor());
			servidorRepository.save(servidorAtualizar);

			return new Servidor(servidorAtualizar);
		}
		return null;
	}

	@Override
	public Servidor deletar(Long idServidor) {
		if (servidorRepository.existsById(idServidor)) {
			servidorRepository.deleteById(idServidor);
		}
		return null;
	}

}

package br.com.tenax.api.tenax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tenax.api.tenax.domain.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

}

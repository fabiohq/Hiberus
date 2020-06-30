package co.com.microconsulta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.microconsulta.entity.PagoPendienteEntity;

public interface IConsultaPagoRepo extends JpaRepository<PagoPendienteEntity, String>{
	
	PagoPendienteEntity getByReferencia(String referencia);
}


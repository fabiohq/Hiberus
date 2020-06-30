package co.com.microconsulta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.microconsulta.entity.PagoPendienteEntity;

public interface IConsultaPagoRepo extends JpaRepository<PagoPendienteEntity, String>{

	List<PagoPendienteEntity> findByDocumento(String documento);	
}


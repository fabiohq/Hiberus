package co.com.microconsulta.service;

import co.com.microconsulta.DTO.ResponseConsultaPagoDTO;

public interface IConsultaPagoServ {
	
	public ResponseConsultaPagoDTO findByDocumento(String documento)throws Exception;
}

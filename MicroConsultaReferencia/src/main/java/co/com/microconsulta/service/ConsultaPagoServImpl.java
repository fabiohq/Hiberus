package co.com.microconsulta.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.microconsulta.DTO.ResponseConsultaPagoDTO;
import co.com.microconsulta.entity.PagoPendienteEntity;
import co.com.microconsulta.helpers.Util;
import co.com.microconsulta.repository.IConsultaPagoRepo;
import co.com.microconsulta.vo.PagoPendienteVO;

@Service
public class ConsultaPagoServImpl implements IConsultaPagoServ{

	@Autowired
	private IConsultaPagoRepo consultaPagoRepo; 
	
	@Override
	public ResponseConsultaPagoDTO getByReferencia(String referencia) throws Exception {
		ResponseConsultaPagoDTO responseConsultaPagoDTO = null;
		try {
			PagoPendienteEntity entity = consultaPagoRepo.getByReferencia(referencia);
			if(entity ==null) {
				responseConsultaPagoDTO = generaDTOIsEmpty();
			}else {
				PagoPendienteVO pagoPendiente = convertirpagoPendiente(entity);
				responseConsultaPagoDTO = generaDTOOk();
				responseConsultaPagoDTO.setPagoPendiente(pagoPendiente);				
			}		
		
		} catch (Exception e) {
			responseConsultaPagoDTO = generaDTOError(e.getMessage());
		}				
		return responseConsultaPagoDTO;
	}

	private PagoPendienteVO convertirpagoPendiente(PagoPendienteEntity entity) {
		
		PagoPendienteVO pagoPendiente= new PagoPendienteVO();
		pagoPendiente.setApellido1(entity.getApellido1());
		pagoPendiente.setApellido2(entity.getApellido2());
		pagoPendiente.setDocumento(entity.getDocumento());
		pagoPendiente.setFechaLimPago(entity.getFechaLimPago());
		pagoPendiente.setNombre1(entity.getNombre1());
		pagoPendiente.setNombre2(entity.getNombre2());
		pagoPendiente.setReferencia(entity.getReferencia());
		pagoPendiente.setValor(entity.getValor());
		
		return pagoPendiente;
	}
	
	private ResponseConsultaPagoDTO generaDTOOk() {
		ResponseConsultaPagoDTO responseConsultaPagoDTO = new ResponseConsultaPagoDTO();
		responseConsultaPagoDTO.setEstado(Util.COD_OK);
		responseConsultaPagoDTO.setDescripcion(Util.DESCRIPCION_OK);
		return responseConsultaPagoDTO;
	}
	
	private ResponseConsultaPagoDTO generaDTOIsEmpty() {
		ResponseConsultaPagoDTO responseConsultaPagoDTO = new ResponseConsultaPagoDTO();
		responseConsultaPagoDTO.setEstado(Util.COD_IS_EMPTY);
		responseConsultaPagoDTO.setDescripcion(Util.DESCRIPCION_S_EMPTY);
		return responseConsultaPagoDTO;
	}
	
	private ResponseConsultaPagoDTO generaDTOError(String mensajeError) {
		ResponseConsultaPagoDTO responseConsultaPagoDTO = new ResponseConsultaPagoDTO();
		responseConsultaPagoDTO.setEstado(Util.COD_ERROR);
		responseConsultaPagoDTO.setDescripcion(mensajeError);
		return responseConsultaPagoDTO;
	}
}
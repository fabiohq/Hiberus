package co.com.microconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.microconsulta.DTO.ResponseConsultaPagoDTO;
import co.com.microconsulta.service.IConsultaPagoServ;

@RestController
@RequestMapping("/consulta")
public class ConsultaPagoCtrl {

	@Autowired
	public IConsultaPagoServ consultaPagoServ; 
	
	@GetMapping("/referencia/{referencia}")
	public ResponseConsultaPagoDTO getPagoByReferencia(@PathVariable("referencia") String referencia) throws Exception {
		return consultaPagoServ.getByReferencia(referencia);
	}
	 
}
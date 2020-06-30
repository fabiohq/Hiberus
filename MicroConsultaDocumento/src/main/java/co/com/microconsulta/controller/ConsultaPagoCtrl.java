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

	@GetMapping("/documento/{documento}")
	public ResponseConsultaPagoDTO getPagoByDocumento(@PathVariable("documento") String documento) throws Exception {
		return consultaPagoServ.findByDocumento(documento);
	}

}
package co.com.microconsulta.DTO;

import java.io.Serializable;
import java.util.List;

import co.com.microconsulta.vo.PagoPendienteVO;

public class ResponseConsultaPagoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String estado;
	private String descripcion;
	private PagoPendienteVO pagoPendiente;
	private List<PagoPendienteVO> pagosPendientes;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public PagoPendienteVO getPagoPendiente() {
		return pagoPendiente;
	}
	public void setPagoPendiente(PagoPendienteVO pagoPendiente) {
		this.pagoPendiente = pagoPendiente;
	}	
	public List<PagoPendienteVO> getPagosPendientes() {
		return pagosPendientes;
	}
	public void setPagosPendientes(List<PagoPendienteVO> pagosPendientes) {
		this.pagosPendientes = pagosPendientes;
	}
	@Override
	public String toString() {
		return "ResponseConsultaPagoDTO [estado=" + estado + ", descripcion=" + descripcion + "]";
	}

}
package co.com.microconsulta.vo;

import java.io.Serializable;

public class PagoPendienteVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double valor;
	private String referencia;
	private String fechaLimPago;
	private String documento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFechaLimPago() {
		return fechaLimPago;
	}
	public void setFechaLimPago(String fechaLimPago) {
		this.fechaLimPago = fechaLimPago;
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	@Override
	public String toString() {
		return "ResponseConsultaPagoDTO [valor=" + valor + ", referencia=" + referencia + ", documento="
				+ documento + ", nombre1=" + nombre1 + ", apellido1=" + apellido1 + "]";
	}
}

package co.com.microconsulta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name =  "PAGO_PENDIENTE")
public class PagoPendienteEntity implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="id_pago_pendiente")
	private Integer idPagoPendiente;
	
	@ManyToOne
	private DetallePagoEntity detallePago;
	
	@Column (name="id_detalle_pago", nullable = true)
	private Integer idDetallePago;
	
	private Double valor;
	private String referencia;
	
	@Column (name ="fecha_limite_pago")
	private String fechaLimPago;
	
	private String documento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	
	public Integer getIdPagoPendiente() {
		return idPagoPendiente;
	}
	public void setIdPagoPendiente(Integer idPagoPendiente) {
		this.idPagoPendiente = idPagoPendiente;
	}	
	public DetallePagoEntity getDetallePago() {
		return detallePago;
	}
	public void setDetallePago(DetallePagoEntity detallePago) {
		this.detallePago = detallePago;
	}
	public Integer getIdDetallePago() {
		return idDetallePago;
	}
	public void setIdDetallePago(Integer idDetallePago) {
		this.idDetallePago = idDetallePago;
	}
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
	
}

package co.com.microconsulta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="DETALLE_PAGO")
public class DetallePagoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="id_detalle_pago")
	private Integer idDetallePago;
	
	@OneToMany(targetEntity=PagoPendienteEntity.class)
	private List<PagoPendienteEntity> pagosPendientes;
	
	@ManyToOne
	private ConsolidadoVendedorEntity consolidadoVendedor;
	
	@Column(name="id_consolidado_vendedor", nullable = true)
	private Integer idConsolidadoVendedor;
	
	@Column(name="fecha_pago")
	private Date fechaPago;
	
	private Double valor;
	private String referencia;
	private String docvendedor;
	private String doccliente;
	
	@Column(name="nombre_cliente")
	private String nombrecliente;
	@Column(name = "hora_venta")
	private String horaVenta;
	
	public Integer getIdDetallePago() {
		return idDetallePago;
	}
	public void setIdDetallePago(Integer idDetallePago) {
		this.idDetallePago = idDetallePago;
	}
	public List<PagoPendienteEntity> getPagosPendientes() {
		return pagosPendientes;
	}
	public void setPagosPendientes(List<PagoPendienteEntity> pagosPendientes) {
		this.pagosPendientes = pagosPendientes;
	}
	public Integer getIdConsolidadoVendedor() {
		return idConsolidadoVendedor;
	}
	public void setIdConsolidadoVendedor(Integer idConsolidadoVendedor) {
		this.idConsolidadoVendedor = idConsolidadoVendedor;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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
	public String getDocvendedor() {
		return docvendedor;
	}
	public void setDocvendedor(String docvendedor) {
		this.docvendedor = docvendedor;
	}
	public String getDoccliente() {
		return doccliente;
	}
	public void setDoccliente(String doccliente) {
		this.doccliente = doccliente;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public String getHoraVenta() {
		return horaVenta;
	}
	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
	}
	public ConsolidadoVendedorEntity getConsolidadoVendedor() {
		return consolidadoVendedor;
	}
	public void setConsolidadoVendedor(ConsolidadoVendedorEntity consolidadoVendedor) {
		this.consolidadoVendedor = consolidadoVendedor;
	}
		
}

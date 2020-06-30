package co.com.microconsulta.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CONSOLIDADO_VENDEDOR")
public class ConsolidadoVendedorEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_consolidado_vendedor")
	private Integer idConsolidadoVendedor;
	
	@OneToMany
	private List<DetallePagoEntity> detallePagos;
	
	private Date fecha;
	private Double valor;
	
	@Column(name ="docvendedor")
	private String docVendedor;

	public Integer getIdConsolidadoVendedor() {
		return idConsolidadoVendedor;
	}

	public void setIdConsolidadoVendedor(Integer idConsolidadoVendedor) {
		this.idConsolidadoVendedor = idConsolidadoVendedor;
	}

	public List<DetallePagoEntity> getDetallePagos() {
		return detallePagos;
	}

	public void setDetallePagos(List<DetallePagoEntity> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDocVendedor() {
		return docVendedor;
	}

	public void setDocVendedor(String docVendedor) {
		this.docVendedor = docVendedor;
	}	
	
}

package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Credito {

	@Id
	@Column(name="codigo_credito")
	private int codigo;
	private Date fechaRegistro;
	private int meses;
	private double monto;
	@OneToOne
	@JoinColumn(name="codigo_solicitud_credito")
	private SolicitudCredito solicitud;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_credito")
	private List<DetalleCredito> detalles;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public SolicitudCredito getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(SolicitudCredito solicitud) {
		this.solicitud = solicitud;
	}
	
	public List<DetalleCredito> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleCredito> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Credito [codigo=" + codigo + ", fechaRegistro=" + fechaRegistro + ", meses=" + meses + ", monto="
				+ monto + ", solicitud=" + solicitud + ", detalles=" + detalles + "]";
	}
}

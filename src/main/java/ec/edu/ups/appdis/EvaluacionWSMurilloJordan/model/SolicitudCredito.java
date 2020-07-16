package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SolicitudCredito {

	@Id
	@Column(name="codigo_solicitud")
	@GeneratedValue
	private int codigo;
	private double monto;
	private int meses;
	@Column(name="fecha_primera_cuota")
	private Date fechaPriCuota;
	@OneToOne
	@JoinColumn(name="numero_cuenta")
	private Cuenta cuenta;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public Date getFechaPriCuota() {
		return fechaPriCuota;
	}
	public void setFechaPriCuota(Date fechaPriCuota) {
		this.fechaPriCuota = fechaPriCuota;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	@Override
	public String toString() {
		return "SolicitudCredito [codigo=" + codigo + ", monto=" + monto + ", meses=" + meses + ", fechaPriCuota="
				+ fechaPriCuota + ", cuenta=" + cuenta + "]";
	}
	
}

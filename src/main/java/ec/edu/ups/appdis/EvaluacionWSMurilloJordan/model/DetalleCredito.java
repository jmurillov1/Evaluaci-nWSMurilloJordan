package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DetalleCredito {

	@Id
	@GeneratedValue
	private int codigo;
	@Column(name="numero_cuota")
	private int numeroCuota;
	@Column(name="fecha_pago")
	private Date fechaPago;
	private double valor;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "DetalleCredito [codigo=" + codigo + ", numeroCuota=" + numeroCuota + ", fechaPago=" + fechaPago
				+ ", valor=" + valor + "]";
	}
}

package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cuenta {

	@Id
	@Column(name="numero_cuenta")
	private int numeroCuenta;
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	private double saldo;
	@OneToOne
	@JoinColumn(name="cedula_cliente")
	private Cliente cliente;
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", fechaRegistro=" + fechaRegistro + ", saldo=" + saldo
				+ ", cliente=" + cliente + "]";
	}
}

package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.services;

import java.text.ParseException;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.business.GestionCreditos;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.SolicitudCredito;

@WebService
public class ServiciosSOAP {
	
	@Inject
	private GestionCreditos creditoON;
	
	@WebMethod
	public String solicitar(String cuentaOrigen, double monto, int meses, String fecha) throws ParseException {
		// metodos que llaman al ON para realizar un deposito
		return creditoON.guardar(cuentaOrigen,monto,meses,fecha);
	}
	
	@WebMethod
	public String aprobar(String codigoSolicitud) {
		// metodos que llaman al ON para realizar un deposito
		return null;
	}
}

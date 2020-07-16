package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.data.CreditoDAO;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.data.SolicitudCreditoDAO;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.Credito;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.Cuenta;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.DetalleCredito;
import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.SolicitudCredito;

@Stateless
public class GestionCreditos {

	@Inject
	private SolicitudCreditoDAO sdao;
	@Inject
	private CreditoDAO cdao;
	@Inject
	private DetalleCredito dcdao;

	public void guardarSolicitud(SolicitudCredito solicitud) {
		try {
			sdao.insertar(solicitud);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	public void guardarCredito(Credito credito) {
		try {
			cdao.insertar(credito);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	public String obtenerFecha2(Date fecha) {
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return hourdateFormat.format(fecha);
	}

	@SuppressWarnings("deprecation")
	public List<DetalleCredito> crearTablaAmortizacion(SolicitudCredito solicitud) {
		List<DetalleCredito> listaDet = new ArrayList<>();

		double vcuota = solicitud.getMonto() / solicitud.getMeses();
		System.out.println("Fecha " + "| Cuota " + "| Capital " + "| Interes " + "| Saldo");
		Date fechaDada = solicitud.getFechaPriCuota();
		for (int i = 1; i <= solicitud.getMeses(); i++) {
			DetalleCredito detalle = new DetalleCredito();
			System.out.println(i + "	|	" + obtenerFecha2(fechaDada) + "	|	" + vcuota);
			detalle.setFechaPago(fechaDada);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(fechaDada.getYear(), fechaDada.getMonth(), fechaDada.getDay());
			calendar1.setTime(fechaDada); // Configuramos la fecha que se recibe
			calendar1.add(Calendar.MONTH, 1);
			fechaDada = calendar1.getTime();// numero de horas a añadir, o restar en caso de horas<0
			detalle.setNumeroCuota(i);
			detalle.setValor(vcuota);
			listaDet.add(detalle);
		}
		return listaDet;
	}

	private Credito buscar(int codigo) {
		return cdao.buscar(codigo);
	}

	public String guardar(String cuentaOrigen, double monto, int meses, String fecha) throws ParseException {
		SolicitudCredito soli = new SolicitudCredito();
		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta(Integer.parseInt(cuentaOrigen));
		soli.setCuenta(cuenta);
		soli.setMeses(meses);
		soli.setMonto(monto);
		String f = fecha;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDada = new Date();
		fechaDada = df.parse(f);
		soli.setFechaPriCuota(fechaDada);
		guardarSolicitud(soli);
		return "Guardado Exitoso";
	}

	public String aprobar(int codigoSolicitud) {
		SolicitudCredito soli = sdao.buscar(codigoSolicitud);
		Credito credito = new Credito();
		credito.setCodigo(1);
		cdao.insertar(credito);
		return null;
	}

	private int generarCodigo() {

		return 0;
	}

}

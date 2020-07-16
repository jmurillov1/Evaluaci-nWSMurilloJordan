package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.DetalleCredito;

public class DetalleCreditoDAO {
	@PersistenceContext(name = "EvaluacionWSMurilloJordanPersistenceUnit")
	private EntityManager em;

	public void insertar(DetalleCredito detalle) {
		em.persist(detalle);
	}
}

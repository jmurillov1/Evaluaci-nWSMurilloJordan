package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.SolicitudCredito;

@Stateless
public class SolicitudCreditoDAO {

	@PersistenceContext(name="EvaluacionWSMurilloJordanPersistenceUnit")
	private EntityManager em;
	public void insertar(SolicitudCredito soliCredito) {
        em.persist(soliCredito);
    }

    public SolicitudCredito buscar(int codigo) {
    	return em.find(SolicitudCredito.class, codigo);
    }
}

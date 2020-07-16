package ec.edu.ups.appdis.EvaluacionWSMurilloJordan.data;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.appdis.EvaluacionWSMurilloJordan.model.Credito;

@Stateless
public class CreditoDAO {

	@PersistenceContext(name="EvaluacionWSMurilloJordanPersistenceUnit")
	private EntityManager em;
	public void insertar(Credito credito) {
        em.persist(credito);
    }

    public Credito buscar(int codigo) {
    	return em.find(Credito.class, codigo);
    }
    
    

}

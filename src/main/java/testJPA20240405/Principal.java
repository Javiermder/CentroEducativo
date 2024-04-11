package testJPA20240405;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import testJPA20240405.model.Coche;

public class Principal {

	public static void main(String[] args) {
		EntityManager em = Persistence.
				createEntityManagerFactory("VentaDeCoches")
				.createEntityManager();	
	//	obtieneUnCoche(em);
//		obtencionUnaSolaEntidadSegundoMetodo(em);
//		actualizaCoche(em, obtieneUnCoche(em, 1));
//		insertarCoche(em);
		eliminaCoche(em, obtieneUnCoche(em, 2051));
		
	}

	
	private static Coche obtieneUnCoche(EntityManager em, int id) {
	
		Coche coche = em.find(Coche.class,id);
		
		//System.out.println("Cochedito"+coche.getModelo());
		return coche;
	}
	

	/**
	 * 
	 */
	private static void obtencionUnaSolaEntidadSegundoMetodo (EntityManager em) {
		

		Query q = em.createNativeQuery("SELECT * FROM coche where id = ?", Coche.class);
		q.setParameter(1, 100);
		Coche coche = (Coche) q.getSingleResult();
		
		if (coche != null) {
			System.out.println("Coche localizado -> " + coche.getId() + " " + coche.getModelo() + " " +
				coche.getColor());
		}
		
		em.close();
	}
	
	
	
	/**
	 * 
	 */
	private static void obtencionUnaSolaEntidadTercerMetodo (EntityManager em) {
		

		TypedQuery<Coche> q = em.createQuery("SELECT c FROM Coche c where c.id = :id", Coche.class);
		q.setParameter("id", 100);
		Coche coche = (Coche) q.getSingleResult();
		
		if (coche != null) {
			System.out.println("Coche localizado -> " + coche.getId() + " " + coche.getModelo() + " " +
				coche.getColor());
		}
		
		em.close();
	}
	
	private static void actualizaCoche(EntityManager em, Coche c) {
		if(c != null) {
			c.setColor("Arcoiris");
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();;
		}
	}
	
	private static void insertarCoche(EntityManager em) {
		Coche c = new Coche();
		c.setIdFabricante(3);
		c.setBastidor("Bastidor");
		c.setColor("Verdeazulado");
		c.setModelo("Megane");
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	private static void eliminaCoche(EntityManager em, Coche c) {
		em.getTransaction();
		em.remove(c);
		em.getTransaction().commit();
	}
	
}

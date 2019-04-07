package no.hvl.dat107.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;
import no.hvl.dat107.entity.Prosjekt;
import no.hvl.dat107.entity.Prosjektdeltagere;
import no.hvl.dat107.entity.ProsjektdeltagereId;

public class DatabaseEAO {
 
	//kunne sikkert ha delt denne klassen opp i fleire mindre klassar som utvider ein hovedklasse...
	private EntityManagerFactory emf;

	DatabaseEAO() {
		emf = Persistence.createEntityManagerFactory("personPersistenceUnit");
	}

	public void leggTil(Object a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void merge(Object a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public List<Ansatt> hentAlleAnsatte() {
		EntityManager em = emf.createEntityManager();
		List<Ansatt> liste = null;
		try {
			liste = em.createQuery("from Ansatt e", Ansatt.class).getResultList();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return liste;
	}
	
	public Ansatt hentAnsatt(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		Ansatt a = null;
		try {
			Query query = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			a = (Ansatt) query.getSingleResult();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public Ansatt hentAnsatt(int id) {
		EntityManager em = emf.createEntityManager();
		Ansatt a = null;
		try {
			a = em.find(Ansatt.class, id);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public Avdeling hentAvdeling(int id) {
		EntityManager em = emf.createEntityManager();
		Avdeling a = null;
		try {
			a = em.find(Avdeling.class, id);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public Prosjekt hentProsjekt(int id) {
		EntityManager em = emf.createEntityManager();
		Prosjekt a = null;
		try {
			a = em.find(Prosjekt.class, id);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public Prosjektdeltagere hentProsjektdeltagere(ProsjektdeltagereId id) {
		EntityManager em = emf.createEntityManager();
		Prosjektdeltagere a = null;
		try {
			a = em.find(Prosjektdeltagere.class, id);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return a;
	}

	public <T> void slettAnsatt(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Ansatt a = em.find(Ansatt.class, id);
			tx.begin();
			em.remove(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void slettAvdeling(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Avdeling a = em.find(Avdeling.class, id);
			tx.begin();
			em.remove(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void slettProsjekt(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Prosjekt a = em.find(Prosjekt.class, id);
			tx.begin();
			em.remove(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void slettProsjektdeltagere(ProsjektdeltagereId id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Prosjektdeltagere a = em.find(Prosjektdeltagere.class, id);
			tx.begin();
			em.remove(a);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}

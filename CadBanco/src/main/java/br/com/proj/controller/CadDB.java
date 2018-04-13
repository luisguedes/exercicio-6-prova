package br.com.proj.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.proj.model.Cad;
import br.com.proj.util.HibernateUtil;

public class CadDB {

	EntityManager entityManager;

	public CadDB() {
		entityManager = HibernateUtil.getEntityManager();
	}

	public boolean insert(Cad cad) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cad);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean update(Cad cad) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(cad);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean delete(Cad cad) {
		try {
			entityManager.getTransaction().begin();
			cad = entityManager.find(Cad.class, cad.getCodigo());
			entityManager.remove(cad);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Cad selectTo(int codigo) {
		try {
			entityManager.getTransaction().begin();
			Cad cad = entityManager.find(Cad.class, codigo);
			entityManager.getTransaction().commit();
			entityManager.close();
			return cad;
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cad> selectAll() {
		return entityManager.createQuery("FROM " + Cad.class.getName()).getResultList();
	}
}
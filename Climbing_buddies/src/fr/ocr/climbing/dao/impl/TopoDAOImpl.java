package fr.ocr.climbing.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.ocr.climbing.dao.TopoDAO;
import fr.ocr.climbing.entity.Topo;
import fr.ocr.climbing.model.TopoInfo;

@Repository
public class TopoDAOImpl implements TopoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public Topo findTopo(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Topo.class);
		crit.add(Restrictions.eq("id", id));
		return (Topo) crit.uniqueResult();
	}

	@Override
	public TopoInfo findTopoInfo(Long id) {
		Topo topo = this.findTopo(id);
		if (topo == null) {
			return null;
		}
		return new TopoInfo(topo.getId(), topo.getNom(), //
				topo.getRegion(), topo.getNbSites(), //
				topo.getNbSecteurs(), topo.getNbVoies(), topo.isDisponible(), topo.getDescription(), topo.getDatePublication());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopoInfo> listTopoInfos() {
		String sql = "Select new " + TopoInfo.class.getName()//
				+ "(t.id, t.nom, t.region, t.nbSites, t.nbSecteurs,  t.nbVoies, t.disponible, t.description, t.datePublication) "//
				+ " from " + Topo.class.getName() + " t ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	public void saveTopo(TopoInfo TopoInfo) {
		Long id = TopoInfo.getId();
		Topo Topo = null;
		if (id != null) {
			Topo = this.findTopo(id);
		}
		boolean isNew = false;
		if (Topo == null) {
			isNew = true;
			Topo = new Topo();
			
		}
	
		Topo.setNom(TopoInfo.getNom());
		Topo.setRegion(TopoInfo.getRegion());
		Topo.setNbSites(TopoInfo.getNbSites());
		Topo.setNbSecteurs(TopoInfo.getNbSecteurs());
		Topo.setNbVoies(TopoInfo.getNbVoies());
		Topo.setDisponible(TopoInfo.isDisponible());
		Topo.setDescription(TopoInfo.getDescription());
		Topo.setDatePublication(TopoInfo.getDatePublication());
		
		
		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(Topo);
		}
	}

	@Override
	public void deleteTopo(Long id) {
		Topo Topo = this.findTopo(id);
		if (Topo != null) {
			this.sessionFactory.getCurrentSession().delete(Topo);
		}
	}

	
	
 
}
package fr.ocr.climbing.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import fr.ocr.climbing.dao.UserDAO;
import fr.ocr.climbing.entity.User;
import fr.ocr.climbing.model.UserInfo;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUser(String id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("id", id));
		return (User) crit.uniqueResult();
	}

	@Override
	public UserInfo findUserInfo(String id) {
		User User = this.findUser(id);
		if (User == null) {
			return null;
		}
		return new UserInfo(User.getId(), User.getName(), //
				User.getEmail(), User.getLogin(), //
				User.getPassword(), User.getCotation());
	}

	@Override
	public List<UserInfo> listUserInfos() {
		String sql = "Select new " + UserInfo.class.getName()//
				+ "(a.id, a.name, a.email, a.login, a.password, a.cotation) "//
				+ " from " + User.class.getName() + " a ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	public void saveUser(UserInfo UserInfo) {
		String id = UserInfo.getId();
		User User = null;
		if (id != null) {
			User = this.findUser(id);
		}
		boolean isNew = false;
		if (User == null) {
			isNew = true;
			User = new User();
			
		}
		User.setEmail(UserInfo.getEmail());
		User.setLogin(UserInfo.getLogin());
		User.setName(UserInfo.getName());
		User.setPassword(UserInfo.getPassword());
		User.setCotation(UserInfo.getCotation());

		
		
		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(User);
		}
	}

	@Override
	public void deleteUser(String id) {
		User User = this.findUser(id);
		if (User != null) {
			this.sessionFactory.getCurrentSession().delete(User);
		}
	}

}
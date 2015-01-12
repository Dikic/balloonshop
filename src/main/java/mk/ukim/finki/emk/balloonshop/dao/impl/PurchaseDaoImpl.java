package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseDao;
import mk.ukim.finki.emk.balloonshop.model.Purchase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchase(Purchase p) {
		getCurrentSession().save(p);
	}

	@Override
	public void deletePurchase(int id) {
		Purchase p = getPurchase(id);
		if (p != null) {
			getCurrentSession().delete(p);
		}
	}

	@Override
	public void updatePurchase(Purchase p) {
		Purchase purchase = getPurchase(p.getId());
		if (purchase != null) {
			purchase.setCanceled(p.isCanceled());
			purchase.setComments(p.getComments());
			purchase.setCompleted(p.isCompleted());
			purchase.setDateCreated(p.getDateCreated());
			purchase.setDateShipped(p.getDateShipped());
			purchase.setPurchaseDetails(p.getPurchaseDetails());
			purchase.setShippingAddress(p.getShippingAddress());
			purchase.setUser(p.getUser());
			purchase.setVerified(p.isVerified());
			getCurrentSession().update(purchase);
		}
	}

	@Override
	public Purchase getPurchase(int id) {
		return (Purchase) getCurrentSession().get(Purchase.class, id);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return (List<Purchase>) getCurrentSession()
				.createQuery("from Purchase").list();
	}
}

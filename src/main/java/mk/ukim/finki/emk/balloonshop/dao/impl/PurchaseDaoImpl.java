package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseDao;
import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Purchase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
			if (p.getDateCreated() != null) {
				purchase.setDateCreated(p.getDateCreated());
			}
			if (p.getDateShipped() != null) {
				purchase.setDateShipped(p.getDateShipped());
			}
			if (p.getPurchaseDetails() != null) {
				purchase.setPurchaseDetails(p.getPurchaseDetails());
			}
			if (p.getShippingAddress() != null) {
				purchase.setShippingAddress(p.getShippingAddress());
			}
			if (p.getUser() != null) {
				purchase.setUser(p.getUser());
			}
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

	@Override
	public long unverifiedCount() {
		return (long) getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.isNull("dateShipped"))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public long uncompletedCount() {
		return (long) getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.eqOrIsNull("completed", false))
				.add(Restrictions.eqOrIsNull("canceled", false))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<Purchase> getPurchasesInRange(int from, int max) {
		Criteria query = getCurrentSession().createCriteria(Purchase.class);

		return query.setFirstResult(from).setMaxResults(max).list();
	}

	@Override
	public int getPurchasesCount() {
		String count = getCurrentSession()
				.createQuery("select count(*) from Purchase").uniqueResult()
				.toString();

		return Integer.parseInt(count);
	}

	@Override
	public List<Purchase> getUnverified() {
		return getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.eq("verified", false)).list();
	}

	@Override
	public List<Purchase> getUncompleted() {
		return getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.eq("completed", false)).list();
	}
}

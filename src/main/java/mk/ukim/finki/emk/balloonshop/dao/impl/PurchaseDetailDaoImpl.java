package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseDetailDao;
import mk.ukim.finki.emk.balloonshop.model.PurchaseDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDetailDaoImpl implements PurchaseDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchaseDetail(PurchaseDetail pd) {
		getCurrentSession().save(pd);
	}

	@Override
	public void deletePurchaseDetail(int id) {
		PurchaseDetail pd = getPurchaseDetail(id);
		if (pd != null) {
			getCurrentSession().delete(pd);
		}
	}

	@Override
	public void updatePurchaseDetail(PurchaseDetail pd) {
		PurchaseDetail purchaseDetail = getPurchaseDetail(pd.getId());
		if (purchaseDetail != null) {
			purchaseDetail.setProduct(pd.getProduct());
			purchaseDetail.setProductName(pd.getProductName());
			purchaseDetail.setPurchase(pd.getPurchase());
			purchaseDetail.setQuantity(pd.getQuantity());
			purchaseDetail.setUnitCost(pd.getUnitCost());
			getCurrentSession().update(purchaseDetail);
		}
	}

	@Override
	public PurchaseDetail getPurchaseDetail(int id) {
		return (PurchaseDetail) getCurrentSession().get(PurchaseDetail.class,
				id);
	}

	@Override
	public List<PurchaseDetail> getAllPurchaseDetails() {
		return (List<PurchaseDetail>) getCurrentSession().createQuery(
				"from PurchaseDetail").list();
	}
}

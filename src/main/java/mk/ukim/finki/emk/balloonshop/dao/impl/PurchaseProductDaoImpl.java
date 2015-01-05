package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseProductDao;
import mk.ukim.finki.emk.balloonshop.model.PurchaseProduct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseProductDaoImpl implements PurchaseProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchaseProduct(PurchaseProduct pp) {
		getCurrentSession().save(pp);
	}

	@Override
	public void deletePurchaseProduct(int id) {
		PurchaseProduct pp = getPurchaseProduct(id);
		if (pp != null) {
			getCurrentSession().delete(pp);
		}
	}

	@Override
	public void updatePurchaseProduct(PurchaseProduct pp) {
		PurchaseProduct purchaseProduct = getPurchaseProduct(pp.getId());
		if (purchaseProduct != null) {
			purchaseProduct.setProduct(pp.getProduct());
			purchaseProduct.setQuantity(pp.getQuantity());
			getCurrentSession().update(purchaseProduct);
		}
	}

	@Override
	public PurchaseProduct getPurchaseProduct(int id) {
		return (PurchaseProduct) getCurrentSession().get(PurchaseProduct.class,
				id);
	}

	@Override
	public List<PurchaseProduct> getAllPurchaseProducts() {
		return (List<PurchaseProduct>) getCurrentSession().createQuery(
				"from PurchaseProduct").list();
	}
}

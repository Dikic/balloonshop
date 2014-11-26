package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseProductDao;
import mk.ukim.finki.emk.balloonshop.model.PurchaseProduct;
import mk.ukim.finki.emk.balloonshop.service.PurchaseProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseProductServiceImpl implements PurchaseProductService {

	@Autowired
	PurchaseProductDao purchaseProductDao;

	@Override
	public void addPurchaseProduct(PurchaseProduct pp) {
		purchaseProductDao.addPurchaseProduct(pp);
	}

	@Override
	public void deletePurchaseProduct(int id) {
		purchaseProductDao.deletePurchaseProduct(id);
	}

	@Override
	public void updatePurchaseProduct(PurchaseProduct pp) {
		purchaseProductDao.updatePurchaseProduct(pp);
	}

	@Override
	public PurchaseProduct getPurchaseProduct(int id) {
		return purchaseProductDao.getPurchaseProduct(id);
	}

	@Override
	public List<PurchaseProduct> getAllPurchaseProducts() {
		return purchaseProductDao.getAllPurchaseProducts();
	}

}

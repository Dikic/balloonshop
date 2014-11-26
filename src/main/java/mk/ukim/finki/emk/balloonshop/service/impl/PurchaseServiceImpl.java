package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseDao;
import mk.ukim.finki.emk.balloonshop.model.Purchase;
import mk.ukim.finki.emk.balloonshop.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PurchaseDao purchaseDao;
	
	@Override
	public void addPurchase(Purchase p) {
		purchaseDao.addPurchase(p);
	}

	@Override
	public void deletePurchase(int id) {
		purchaseDao.deletePurchase(id);
	}

	@Override
	public void updatePurchase(Purchase p) {
		purchaseDao.updatePurchase(p);
	}

	@Override
	public Purchase getPurchase(int id) {
		return purchaseDao.getPurchase(id);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseDao.getAllPurchases();
	}

}

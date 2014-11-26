package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.PurchaseDetailDao;
import mk.ukim.finki.emk.balloonshop.model.PurchaseDetail;
import mk.ukim.finki.emk.balloonshop.service.PurchaseDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

	@Autowired
	PurchaseDetailDao purchaseDetailDao;

	@Override
	public void addPurchaseDetail(PurchaseDetail pd) {
		purchaseDetailDao.addPurchaseDetail(pd);
	}

	@Override
	public void deletePurchaseDetail(int id) {
		purchaseDetailDao.deletePurchaseDetail(id);
	}

	@Override
	public void updatePurchaseDetail(PurchaseDetail pd) {
		purchaseDetailDao.updatePurchaseDetail(pd);
	}

	@Override
	public PurchaseDetail getPurchaseDetail(int id) {
		return purchaseDetailDao.getPurchaseDetail(id);
	}

	@Override
	public List<PurchaseDetail> getAllPurchaseDetails() {
		return purchaseDetailDao.getAllPurchaseDetails();
	}

}

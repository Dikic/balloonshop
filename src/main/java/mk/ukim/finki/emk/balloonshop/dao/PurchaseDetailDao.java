package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.PurchaseDetail;

public interface PurchaseDetailDao {

	public void addPurchaseDetail(PurchaseDetail pd);

	public void deletePurchaseDetail(int id);

	public void updatePurchaseDetail(PurchaseDetail pd);

	public PurchaseDetail getPurchaseDetail(int id);

	public List<PurchaseDetail> getAllPurchaseDetails();

}

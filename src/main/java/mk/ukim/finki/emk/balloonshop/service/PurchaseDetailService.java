package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.PurchaseDetail;

public interface PurchaseDetailService {
	/**
	 * @param pd
	 *            input parameter to save
	 */
	public void addPurchaseDetail(PurchaseDetail pd);

	/**
	 * 
	 * @param id
	 */
	public void deletePurchaseDetail(int id);

	public void updatePurchaseDetail(PurchaseDetail pd);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PurchaseDetail getPurchaseDetail(int id);

	public List<PurchaseDetail> getAllPurchaseDetails();
}

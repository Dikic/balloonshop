package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Purchase;

public interface PurchaseDao {

	public void addPurchase(Purchase p);

	public void deletePurchase(int id);

	public void updatePurchase(Purchase p);

	public Purchase getPurchase(int id);

	public List<Purchase> getAllPurchases();

	public long unverifiedCount();

	public long uncompletedCount();

	public List<Purchase> getPurchasesInRange(int from, int max); // for paging
																	// on admin
																	// page

	public int getPurchasesCount();

	public List<Purchase> getUnverified();

	public List<Purchase> getUncompleted();

}

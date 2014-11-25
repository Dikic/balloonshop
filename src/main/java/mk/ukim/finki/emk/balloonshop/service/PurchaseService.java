package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Purchase;

public interface PurchaseService {

	public void addPurchase(Purchase p);

	public void deletePurchase(int id);

	public void updatePurchase(Purchase p);

	public Purchase getPurchase(int id);

	public List<Purchase> getAllPurchases();
}

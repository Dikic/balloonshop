package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.PurchaseProduct;

public interface PurchaseProductService {

	public void addPurchaseProduct(PurchaseProduct pp);

	public void deletePurchaseProduct(int id);

	public void updatePurchaseProduct(PurchaseProduct pp);

	public PurchaseProduct getPurchaseProduct(int id);

	public List<PurchaseProduct> getAllPurchaseProducts();
}

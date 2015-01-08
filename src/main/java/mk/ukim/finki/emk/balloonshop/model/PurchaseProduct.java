package mk.ukim.finki.emk.balloonshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseProduct {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Purchase purchase;

	@ManyToOne
	private Product product;

	private int quantity;

	public int getId() {
		return id;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

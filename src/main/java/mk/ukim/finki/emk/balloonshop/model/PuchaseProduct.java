package mk.ukim.finki.emk.balloonshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PuchaseProduct {

	@Id
	@GeneratedValue
	private int id;

	@OneToMany(mappedBy = "puchaseProduct")
	private List<Purchase> purchases;

	@OneToMany(mappedBy = "puchaseProduct")
	private List<Product> products;

	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

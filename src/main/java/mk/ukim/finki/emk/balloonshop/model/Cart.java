package mk.ukim.finki.emk.balloonshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Formula;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<CartProduct> cartProduct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartProduct> getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(List<CartProduct> cartProduct) {
		this.cartProduct = cartProduct;
	}

	@Formula("(SELECT COUNT(*) FROM CartProduct as c WHERE c.cart_id=id)")
	private int productCount;

	public int getProductCount() {
		return productCount;
	}

}

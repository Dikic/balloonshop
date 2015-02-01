package mk.ukim.finki.emk.balloonshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String description;

	private double price;

	private String smallImage;
	private CommonsMultipartFile fileSmallImage;

	private String largeImage;
	private CommonsMultipartFile fileLargeImage;

	private boolean onPromotion;

	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Category> categories;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<CartProduct> cartProducts;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<PurchaseDetail> purchaseDetails;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<PurchaseProduct> purchaseProducts;

	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public List<PurchaseProduct> getPurchaseProducts() {
		return purchaseProducts;
	}

	public void setPurchaseProducts(List<PurchaseProduct> purchaseProducts) {
		this.purchaseProducts = purchaseProducts;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public boolean isOnPromotion() {
		return onPromotion;
	}

	public void setOnPromotion(boolean onPromotion) {
		this.onPromotion = onPromotion;
	}

	public CommonsMultipartFile getFileSmallImage() {
		return fileSmallImage;
	}

	public void setFileSmallImage(CommonsMultipartFile fileSmallImage) {
		this.fileSmallImage = fileSmallImage;
	}

	public CommonsMultipartFile getFileLargeImage() {
		return fileLargeImage;
	}

	public void setFileLargeImage(CommonsMultipartFile fileLargeImage) {
		this.fileLargeImage = fileLargeImage;
	}

}

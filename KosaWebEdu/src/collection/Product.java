package collection;

import java.util.Objects;

public class Product {
	private String productID;
	private String productName;
	private String productPrice;
	
	public Product() {}
	public Product(String productID, String productName, String productPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getProductID() {
		return productID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getProductPrice() {
		return productPrice;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.hashCode() == obj.hashCode()) return true;
		return super.equals(obj);
	}
	
	
}

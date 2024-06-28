package collection;

public class Product2 extends Product implements Comparable<Product2> {
	private String productID;
	private String productName;
	private String productPrice;
	
	public Product2 () {}
	public Product2 (String productID, String productName, String productPrice) {
		super(productID, productName, productPrice);
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return productID + "\t\t" + productName + "\t\t" + String.format("%,d원", Integer.parseInt(productPrice));
	}
	
	@Override
	public int compareTo(Product2 obj) {
		int price = Integer.parseInt(productPrice);
		int comp = Integer.parseInt(obj.productPrice);
		
		return price > comp ? -1 : price == comp ? 0 : 1;
	}
	
}

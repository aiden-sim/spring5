package chapter2.part10_2.shop;

import java.util.Map;

public class ProductCreator {
	private Map<String, Product> products;

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	public Product createProduct(String productId) {
		Product product = products.get(productId);
		if (product != null) {
			return product;
		}
		throw new IllegalArgumentException("Unknow product");
	}
}

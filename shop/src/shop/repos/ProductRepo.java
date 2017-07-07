package shop.repos;

import java.util.ArrayList;
import java.util.List;

import shop.model.Product;
import shop.model.ProductType;

public class ProductRepo {

	private List<Product> products;

	public ProductRepo() {
			init();
		
	}
	
	private void init(){
		products = new ArrayList<>();

		products.add(new Product(1, "samsung8", 500.50, ProductType.MOBILE));
		products.add(new Product(2, "LG TV", 1000.50, ProductType.ELECTROCASNICE));
		products.add(new Product(3, "ASUS Notebook", 400.50, ProductType.CALCULATOARE));
		products.add(new Product(4, "DELL Notebook", 300.50, ProductType.CALCULATOARE));
	}

	
	public List<Product> findAll(){
		return products;
	}
}

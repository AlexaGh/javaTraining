package shop.print.utils;

import shop.model.Product;

public class PrintPrice implements PrintIf{

	@Override
	public void print(Product product) {
		System.out.println(product.getPrice());
		
	}

}

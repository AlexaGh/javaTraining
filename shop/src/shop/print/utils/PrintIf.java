package shop.print.utils;

import shop.model.Product;

@FunctionalInterface
public interface PrintIf {

	public void print(Product product);
}

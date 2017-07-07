package shop.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

import shop.print.utils.PrintIf;
import shop.repos.ProductRepo;

public class Shop {

	private static ProductRepo repo = new ProductRepo();
	private int counter = 0;
	private int counter2 = 0;

	public static void main(String[] args) {

		Shop shop = new Shop();
		// Consumer<Product> printNameStrategy = p ->
		// System.out.println(p.getName());
		// Consumer<Product> printUpperNames = System.out::println;

		// System.out.println("printProducts using PrintIf:");
		// shop.printProducts(shop.getRepo().findAll(), p ->
		// System.out.println(p.getName()));

		// System.out.println("printProducts using ConsumerIf:");
		// shop.printAll(shop.getRepo().findAll(), p ->
		// System.out.println(p.getName()));

		// System.out.println("sorted products:");
		// shop.printAll(shop.sortProductsWithMethodRef(), printUpperNames);

		// System.out.println(shop.copy(shop.getRepo().findAll().get(0)
		// ).toString());

		// System.out.println(shop.getCounter());

		System.out.println("numele produselor cu upper case using streams: ");
		shop.getRepo().findAll().stream().map(p -> p.getName()).forEach(StringUtils::upperCase);

		System.out.println();
		System.out.println("numele persoanleor afisate cu streams: ");
		String[] text = { "Boti", "Adrian", "Traian", "Damira" };
		Stream.of(text).forEach(p -> System.out.println(p));
		;

		System.out.println();
		System.out.println("from stream to array and back: ");
		Stream myStream = Stream.of(text);
		String[] myArray = (String[]) myStream.toArray(String[]::new);
		Stream.of(myArray).forEach(p -> System.out.println(p));
		;

		List<String> text1 = Arrays.asList(text);

		System.out.println();
		System.out.println("again: ");
		text1.stream().forEach(p -> System.out.println(p));
		System.out.println();

		text1.stream().map(p -> {
			p.toUpperCase();
			System.out.println(p);
			return p.toUpperCase();
		});

		System.out.println();
		System.out.println("filtered, products with price greater than 500");
		shop.getRepo()
				.findAll()
				.stream()
				.filter(p -> p.getPrice() > 500)
				.forEach(p -> System.out.println(p));
		;

		System.out.println();
		System.out.println("filtered, sum of the prices > 500:");
		Optional<Product> sum = shop.getRepo()
			.findAll()
			.stream()
			.filter(p -> p.getPrice() > 500)
			.findFirst();
			//.mapToDouble(p -> p.getPrice())
			//.sum();
		System.out.println("sum of the prices :" + sum);
		

	}

	public void printAll(List<Product> products, Consumer<Product> strategyPrint) {
		// int counter = 0;
		products.forEach(p -> {
			strategyPrint.accept(p);
			counter++;
		});
	}

	public void printProducts(List<Product> products, PrintIf strategyPrint) {
		products.forEach(p -> {
			strategyPrint.print(p);
			counter++;
		});
	}

	public static ProductRepo getRepo() {
		return repo;
	}

	public List<Product> sortProducts() {
		List<Product> products = repo.findAll();

		// BiFunction<Integer, Product, Product> comparator = (p1, p2) ->
		// (Integer) (p1.getPrice() - p2.getPrice());
		Collections.sort(products, (p1, p2) -> (int) (p1.getPrice() - p2.getPrice()));
		return products;
	}

	public List<Product> sortProductsWithMethodRef() {
		List<Product> products = repo.findAll();

		List<String> prodNames = new ArrayList<>();
		for (Product product : products) {
			prodNames.add(product.getName());
		}

		Collections.sort(prodNames, String::compareTo);

		Collections.sort(prodNames, (p1, p2) -> p1.compareTo(p2));

		return products;
	}

	public int getCounter() {
		return counter;
	}

	public static void setRepo(ProductRepo repo) {
		Shop.repo = repo;
	}

	public Product copy(Product p) {

		Supplier<Product> productSupplier = Product::new;

		Product p2 = productSupplier.get();
		p2.setName(p.getName());
		return p2;
	}

}

package calc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Calculator {

	public static void main(String[] args) {

		Calculator calc = new Calculator();

		Operation add1 = new Add();
		
		BinaryOperator<Double> add = add1::calc;
		
		BinaryOperator<Double> sub = (a, b) -> a - b;
		BinaryOperator<Double> mul = (a, b) -> a * b;
		BinaryOperator<Double> div = (a, b) -> {
			if (b == 0)
				throw new IllegalArgumentException("division by zero!");
			return (a / b);
		};

		calc.print(add, 2D, 3D);
		calc.print(sub, 2D, 3D);
		calc.print(mul, 2D, 3D);
		calc.print(div, 2D, 1D);

		Consumer<BinaryOperator<Double>> printer = p -> System.out.println(p.apply(4D, 5D));
		printer.accept(add);

	}

	public void print(BinaryOperator<Double> operation, Double a, Double b) {
		System.out.println(operation.apply(a, b));
	}

	/*public static void main(String[] args) {

		Calculator calc = new Calculator();

		Operation add = (a, b) -> a + b;
		Operation sub = (a, b) -> a - b;
		Operation mul = (a, b) -> a * b;
		Operation div = (a, b) -> {
			if (b == 0)
				throw new IllegalArgumentException("division by zero!");
			return (a / b);
		};

		calc.print(add, 2D, 3D);
		calc.print(sub, 2D, 3D);
		calc.print(mul, 2D, 3D);
		calc.print(div, 2D, 1D);
	}

	public void print(Operation operation, Double a, Double b) {
		System.out.println(operation.calc(a, b));
	}
	 */
}

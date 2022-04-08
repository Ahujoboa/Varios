package pruebasLambda;

import java.util.List;

public class main {

	public static void main(String[] args) {

		//declarativo(List.of(18, 6, 4, 15, 55, 78, 12, 9, 8));
		imperativo();
	}

	// método declarativo
	public static void declarativo(List<Integer> numbers) {
		for (Integer integer : numbers) {
			if (integer > 10) {
				System.out.println(integer);
			}
		}
	}

	// método imperativo
	public static void imperativo() {

		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		System.out.println(numbers.stream().filter(num -> num > 10).count());
	}

}

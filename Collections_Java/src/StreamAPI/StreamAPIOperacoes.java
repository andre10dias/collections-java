package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPIOperacoes {

	public static void main(String[] args) {

		List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6","5");
		
		System.out.println("Imprima todos os elementos desta lista");
		//numerosAleatorios.stream().forEach(s -> System.out.println(s));
		//numerosAleatorios.forEach(s -> System.out.println(s));
		//numerosAleatorios.stream().forEach(System.out::println);
		
		System.out.println("Pegue os 5 primeiros números e coloque dentro de um set: ");
		numerosAleatorios.stream().limit(5)
			.collect(Collectors.toSet()).forEach(System.out::println);
		//Set<String> collectSet = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());
		
		System.out.println("Transforme esta lista de String em uma lista de números inteiros. ");
		//numerosAleatorios.stream().map(s -> Integer.parseInt(s));
		List<Integer> numerosIntegers = numerosAleatorios.stream()
					.map(Integer::parseInt).collect(Collectors.toList());
		
		System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
		/*List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.filter(new Predicate<Integer>() {
					@Override
					public boolean test(Integer i) {
						if (i % 2 == 0 && i > 2) {
							return true;
						}
						return false;
					}
				})
				.collect(Collectors.toList());*/
		
		List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
				.map(Integer::parseInt)
				.filter(i -> i % 2 == 0 && i > 2)
				.collect(Collectors.toList());
		
		System.out.println(listParesMaioresQue2);
		
		System.out.println("Mostre a média dos números: ");
		/*numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
			@Override
			public int applyAsInt(String s) {
				return Integer.parseInt(s);
			}
		});*/
		
		numerosAleatorios.stream().mapToInt(s -> Integer.parseInt(s))
			.average().ifPresent(System.out::println);
		
		System.out.println("Remova os valores ímpares: ");
		List<Integer> numerosIntegers2 = numerosAleatorios.stream()
				.map(Integer::parseInt).collect(Collectors.toList());
		
		/*numerosIntegers2.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				if (t % 2 != 0) {
					return true;
				}
				return false;
			}
		});*/
		
		numerosIntegers2.removeIf(t -> t % 2 != 0);
		
		System.out.println(numerosIntegers2);
		
	}

}

package Set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Listas_Set {

	public static void main(String[] args) {
		
		//Não aceita valores repetidos, não possui indice e exibe os dados de forma aleatória
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println(notas);
		
		System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5d));
		
		System.out.println("\nExiba a menor nota: " + Collections.min(notas));
		
		System.out.println("\nExiba a maior nota: " + Collections.max(notas));
		
		System.out.print("\nExiba a soma dos valores: "); 
		Iterator<Double> iterator = notas.iterator(); 
		Double soma = 0d; 
		while(iterator.hasNext()) { 
			soma +=
			iterator.next(); 
		} 
		System.out.println(soma);
		
		System.out.println("\nExiba a média das somas: " + soma/notas.size());
		
		System.out.print("\nRemova a nota zero: "); notas.remove(0d);
		System.out.println(notas);
		  
		System.out.print("\nRemova as notas menores que 7: "); 
		Iterator<Double> iterator2 = notas.iterator(); 
		while(iterator2.hasNext()) { 
			if (iterator2.next() < 7d) { 
				iterator2.remove(); 
			} 
		}
		System.out.println(notas);
		
		System.out.print("\nExiba as ntoas na ordem de inserção: ");
		Set<Double> notas2 = new LinkedHashSet<Double>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d);
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);
		
		System.out.println("\nExiba todas as notas na ordem crescente: ");
		Set<Double> notas3 = new TreeSet<Double>(notas2);
		System.out.println(notas3);
		
		System.out.println("\nApague todo o conjunto 1");
		notas.clear();
		
		System.out.println("\nConfira se o conjunto 1 está vazio: " + notas.isEmpty());
		

	}

}

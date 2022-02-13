package Listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Listas {

	public static void main(String[] args) {

		List<Double> notas = new ArrayList<Double>();
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		
		System.out.println(notas);
		
		System.out.println("\nExiba a posição da nota 5.0: " + notas.indexOf(5d));
		
		System.out.println("\nAdicione a nota 8.0 na posição 4: ");
		notas.add(4, 8d);
		System.out.println(notas);
		
		System.out.println("\nSubstitua a nota 5.0 pela nota 6.0: ");
		notas.set(notas.indexOf(5d), 6.0);
		System.out.println(notas);
		
		System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5d));
		
		System.out.println("\nExiba as notas na ordem em que foram inseridas: ");
		for (Double nota : notas) {
			System.out.println(nota);
		}
		
		System.out.println("\nExiba a terceira nota adicionada: " + notas.get(2));
		
		System.out.println("\nExiba a menor nota: " + Collections.min(notas));
		
		System.out.println("\nExiba a maior nota: " + Collections.max(notas));
		
		System.out.print("\nExiba a soma dos valores: ");
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0d;
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);
		
		System.out.println("\nExiba a média das somas: " + soma/notas.size());
		
		System.out.print("\nRemova a nota zero: ");
		notas.remove(0d);
		System.out.println(notas);
		
		System.out.println("\nRemova a nota da posição zero: " + notas.remove(0));
		System.out.println(notas);
		
		System.out.print("\nRemova as notas menores que 7: ");
		Iterator<Double> iterator2 = notas.iterator();
		while(iterator2.hasNext()) {
			if (iterator2.next() < 7d) {
				iterator2.remove();
			}
			iterator2.next();
		}
		System.out.println(notas);
		
		/*
		 * System.out.print("\nApague toda a lista: "); notas.clear();
		 * System.out.println(notas);
		 */
		
		System.out.print("\nConfira se a lista está vazia: ");
		System.out.println(notas.isEmpty());
		
		System.out.println("\n\n*** Resolva utilizando os métodos da implementação LinkedList ***");
		
		System.out.print("\nCrie uma lista chamada lista2 "
				+ "e adicione todos os elementos da lista anterior: ");
		LinkedList<Double> lista2 = new LinkedList<Double>();
		lista2.addAll(notas);
		System.out.println(lista2);
		
		System.out.println("\nMostre a primeira nota da nova lista sem removê-lo: " + lista2.getFirst());
		System.out.println(lista2);
		
		System.out.println("\nMostre a primeira nota da nova lista removendo-o: " + lista2.pollFirst());
		System.out.println(lista2);
		
	}

}

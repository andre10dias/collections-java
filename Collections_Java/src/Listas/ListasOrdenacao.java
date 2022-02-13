package Listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListasOrdenacao {

	public static void main(String[] args) {
		
		List<Gato> meusGatos = new ArrayList<>() {{
			add(new Gato("Jon", 18, "preto"));
			add(new Gato("Simba", 6, "tigrado"));
			add(new Gato("Jon", 12, "amarelo"));
		}};
		
		System.out.println(meusGatos);
		
		System.out.println("\nOrdem aleatória: ");
		Collections.shuffle(meusGatos);
		System.out.println(meusGatos);
		
		System.out.println("\nOrdem natural (nome): ");
		//Precisa que a classe (Gato) implemente a interface Comparable
		Collections.sort(meusGatos);
		System.out.println(meusGatos);
		
		System.out.println("\nOrdem idade: ");
		Collections.sort(meusGatos, new ComparatorIdade());
		System.out.println("Forma 1: " + meusGatos);
		meusGatos.sort(new ComparatorIdade());
		System.out.println("Forma 2: " + meusGatos);
		
		System.out.println("\nOrdem cor: ");
		Collections.sort(meusGatos, new ComparatorCor());
		System.out.println("Forma 1: " + meusGatos);
		meusGatos.sort(new ComparatorCor());
		System.out.println("Forma 2: " + meusGatos);
		
		System.out.println("\nOrdem nome/cor/idade: ");
		Collections.sort(meusGatos, new ComparatorNomeCorIdade());
		System.out.println("Forma 1: " + meusGatos);
		meusGatos.sort(new ComparatorNomeCorIdade());
		System.out.println("Forma 2: " + meusGatos);

	}

}

class Gato implements Comparable<Gato> {
	private String nome;
	private Integer idade;
	private String cor;
	
	public Gato(String nome, Integer idade, String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "{ "
			+ "nome = '" + this.getNome() + '\''
			+ ", idade = " + this.getIdade()
			+ ", cor = '" + this.getCor() + '\''
			+" }";
	}

	@Override
	public int compareTo(Gato gato) {
		/* retorna 0 se forem iguais 
		 * 1 se o primeiro for maior que o segundo 
		 * e -1 se o segundo for maior que o primeiro */
		return this.getNome().compareToIgnoreCase(gato.getNome());
	}
	
}

class ComparatorIdade implements Comparator<Gato> {

	@Override
	public int compare(Gato g1, Gato g2) {
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}
	
}

class ComparatorCor implements Comparator<Gato> {

	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
	
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
	
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
		if (nome != 0) {
			return nome;
		}
		
		int idade = Integer.compare(g1.getIdade(), g2.getIdade());
		if (idade != 0) {
			return idade;
		}
		
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
	
}

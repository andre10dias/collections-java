package Set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SetOrdenacao {

	public static void main(String[] args) {

		System.out.println("Ordem aleatória");
		Set<Serie> minhasSeries = new HashSet<Serie>() {{
			add(new Serie("got", "fantasia", 60));
			add(new Serie("dark", "drama", 60));
			add(new Serie("that '70s show", "comédia", 25));
		}};
		for (Serie serie : minhasSeries) {
			System.out.println(serie.getNome() + " - " 
					+ serie.getGenero() + " - "
					+ serie.getTempoEpisodio());
		}
		
		System.out.println("\nOrdem inserção");
		Set<Serie> minhasSeries2 = new LinkedHashSet<Serie>() {{
			add(new Serie("got", "fantasia", 60));
			add(new Serie("dark", "drama", 60));
			add(new Serie("that '70s show", "comédia", 25));
		}};
		for (Serie serie : minhasSeries2) {
			System.out.println(serie.getNome() + " - " 
					+ serie.getGenero() + " - "
					+ serie.getTempoEpisodio());
		}
		
		System.out.println("\nOrdem natural (tempoEpisodio): ");
		Set<Serie> minhasSeries3 = new TreeSet<Serie>(minhasSeries2);
		System.out.println(minhasSeries3);
		
		
		System.out.println("\nOrdem nome/genero/tempoEpisodio: ");
		Set<Serie> minhasSeries4 = new TreeSet<Serie>(new ComparatorNomeGeneroTempoEpisodio());
		minhasSeries4.addAll(minhasSeries);
		System.out.println(minhasSeries4);
		

	}

}

class Serie implements Comparable<Serie> {
	private String nome;
	private String genero;
	private Integer tempoEpisodio;
	
	public Serie(String nome, String genero, Integer tempoEpisodio) {
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getTempoEpisodio() {
		return tempoEpisodio;
	}

	public void setTempoEpisodio(Integer tempoEpisodio) {
		this.tempoEpisodio = tempoEpisodio;
	}

	@Override
	public String toString() {
		return "{ "
				+ "nome = '" + this.getNome() + '\''
				+ ", genero = '" + this.getGenero() + '\''
				+ ", tempoEpisodio = " + this.getTempoEpisodio()
				+ " }";
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, nome, tempoEpisodio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(nome, other.nome)
				&& Objects.equals(tempoEpisodio, other.tempoEpisodio);
	}

	@Override
	public int compareTo(Serie serie) {
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if (tempoEpisodio != 0) {
			return tempoEpisodio;
		}
		
		return this.getGenero().compareTo(serie.getGenero());
	}
	
	
	
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie serie1, Serie serie2) {
		int nome = serie1.getNome().compareToIgnoreCase(serie2.getNome());
		if (nome != 0) {
			return nome;
		}
		
		int genero = serie1.getGenero().compareToIgnoreCase(serie2.getGenero());
		if (genero != 0) {
			return genero;
		}
		
		return Integer.compare(serie1.getTempoEpisodio(), serie2.getTempoEpisodio());
	}
	
}

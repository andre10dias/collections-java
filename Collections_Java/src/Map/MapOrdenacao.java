package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapOrdenacao {
	
	public static void main(String[] args) {
		
		System.out.println("Ordem aleatória: ");
		Map<String, Livro> meusLivros = new HashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma Breve História do tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
		}};
		for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {			
			System.out.println(livro.getKey() + " - " + livro.getValue());
		}
		
		System.out.println("\nOrdem inserção: ");
		Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma Breve História do tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
		}};
		for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {			
			System.out.println(livro.getKey() + " - " + livro.getValue());
		}
		
		System.out.println("\nOrdem alfabética autores: "); //ordena pela chave
		Map<String, Livro> meusLivros3 = new TreeMap<String, Livro>(meusLivros2);
		for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()) {			
			System.out.println(livro.getKey() + " - " + livro.getValue());
		}
		
		System.out.println("\nOrdem alfabética nomes dos livros: "); //ordena pelo valor
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
		meusLivros4.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livro : meusLivros4) {			
			System.out.println(livro.getKey() + " - " + livro.getValue());
		}
		
		System.out.println("\nOrdenar pelo número de páginas: ");
		Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPagina());
		meusLivros5.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livro : meusLivros5) {			
			System.out.println(livro.getKey() + " - " + livro.getValue());
		}
		
	}

}

class Livro {
	private String nome;
	private Integer paginas;
	
	public Livro(String nome, Integer paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
	}
	
	
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> livro1, Entry<String, Livro> livro2) {
		return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
	}
	
	
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> livro1, Entry<String, Livro> livro2) {
		return Integer.compare(livro1.getValue().getPaginas(), livro2.getValue().getPaginas());
	}
	
	
}

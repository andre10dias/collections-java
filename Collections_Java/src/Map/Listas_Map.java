package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Listas_Map {

	public static void main(String[] args) {

		Map<String, Double> carros = new HashMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		
		System.out.println(carros);
		
		System.out.println("\nSubstitua o consumo do gol por 15.2 km/l: ");
		carros.put("gol", 15.2);
		System.out.println(carros);
		
		System.out.println("\nConfira se o modelo tucson está no dicionario: " 
				+ carros.containsKey("tucson"));
		
		System.out.println("\nExiba o consumo do uno: " + carros.get("uno"));
		
		//retorna um Set<>
		System.out.println("\nExiba os modelos: " + carros.keySet());
		
		//retorna uma collection
		System.out.println("\nExiba o consumo dos carros: " + carros.values());
		
		System.out.println("\nExiba o modelo mais economico e seu consumo: ");
		Double consumo = Collections.max(carros.values());
		//Entrie - trabalha com chave e valor separadamente
		Set<Map.Entry<String, Double>> entries = carros.entrySet();
		String modelo = "";
		for (Map.Entry<String, Double> entry : entries) {
			if (entry.getValue().equals(consumo)) {
				modelo = entry.getKey();
				System.out.println("Modelo: " + modelo + " - " + consumo);
			}
		}
		
		System.out.println("\nExiba o modelo menos economico e seu consumo: ");
		Double consumo2 = Collections.min(carros.values());
		Set<Map.Entry<String, Double>> entries2 = carros.entrySet();
		String modelo2 = "";
		for (Map.Entry<String, Double> entry : entries2) {
			if (entry.getValue().equals(consumo2)) {
				modelo2 = entry.getKey();
				System.out.println("Modelo: " + modelo2 + " - " + consumo2);
			}
		}
		
		System.out.print("\nExiba a soma dos consumos: ");
		Double soma = 0d;
		Iterator<Double> iterator = carros.values().iterator();
		while(iterator.hasNext()) {
			soma += iterator.next();
		}
		/*
		 * Set<Map.Entry<String, Double>> entries3 = carros.entrySet(); for
		 * (Map.Entry<String, Double> entry : entries3) { soma += entry.getValue(); }
		 */
		System.out.println(soma);
		
		System.out.println("\nExiba a média dos consumos: " + soma/carros.size());
		
		System.out.println("\nRemova os modelos com o consumo igual a 15.6 km/l: ");
		Iterator<Double> iterator2 = carros.values().iterator();
		while(iterator2.hasNext()) {
			if (iterator2.next() == 15.6) {
				iterator2.remove();
			}
		}
		System.out.println(carros);
		
		System.out.println("\nExiba os carros na ordem de inserção: ");
		Map<String, Double> carros2 = new LinkedHashMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		
		System.out.println(carros2);
		
		System.out.println("\nExiba os carros ordenado pelo modelo: ");
		Map<String, Double> carros3 = new TreeMap<String, Double>(carros2);
		System.out.println(carros3);
		
		System.out.println("\nApague o dicionario de carros: ");
		carros.clear();
		
		System.out.println("\nConfira se o dicionário está vazio: " + carros.isEmpty());
		

	}

}

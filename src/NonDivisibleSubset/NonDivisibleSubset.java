package NonDivisibleSubset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonDivisibleSubset {

	public int encontrar(Integer k, List<Integer> s) {
		Map<Integer, Integer> mapContResto = new HashMap<>();
		int resultado = 0;
		
		 /*Aqui é varrido todas as entradas e calculando o resto da divisão de s[i] por k. Os resultados são acumulados utilizando o resto como chave e a contagem como valor*/
		for (int i = 0; i < s.size(); i++) {
			int resto = s.get(i) % k;
			Integer val = mapContResto.containsKey(resto) ? mapContResto.get(resto) + 1 : 1;
			mapContResto.put(resto, val);
		}
		
		/*Se contem algo que gere um resto 0, o valor da chave 0 do mapa será 1 ou mais. Porém podemos considerar apenas um desses números do subset
		 *Caso contrario a somatória de dois numeros divisiveis por k resulta em outro também divisível. Portanto considerar no máximo 1*/
		if(mapContResto.containsKey(0)) {
			resultado += 1;
		}
		
		/*Para numeros pares segue a mesma regra do if acima, pois podemos considerar apenas um nnúmero par no subset. 
		 * Dado que x numeros pares somados sempre serão divisiveis por outro par*/
		if (k % 2 == 0) {
			resultado += 1;
		}
		
		/*Itera apenas metade do k, lendo os valores quesão complementares (val1 e val2). 
		 * Necessário considerar apenas o val que apresenta uma contagem maior, pois estamos buscando a maior subset.
		 * Não podemos considerar os dois pois são complementares, e portanto quando considerados juntos geral valores divisiveis por k*/
		for (int i = 1; i < (k / 2) + 1; i++) {
			if (i != k - i) {
				Integer val1 = mapContResto.containsKey(i) ? mapContResto.get(i) : 0;
				Integer val2 = mapContResto.containsKey(k - i) ? mapContResto.get(k - i) : 0;
				resultado += Math.max(val1, val2);
			}
		}
		return resultado;
	}

	
	
	
}

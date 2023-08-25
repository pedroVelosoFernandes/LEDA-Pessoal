package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {	
		T res = null;
		if(array != null && array.length > 0 && k > 0 && k <= array.length){
			if(array.length > 1){
				int limiteInferior = selecionaMenor(array,0,0);
				res = array[auxiliar(array, k, limiteInferior)];
			}
			else{
				res = array[0];
			}
			
		}
		return res;
	}
	private int auxiliar(T[] array,int k,int base){
		int maior = selecionaMaior(array,0,0);
		if(k>1){
			base = selecionaMenorBase(array, 0, maior, base);
			auxiliar(array, k-1,base);
		}
		return base;
	}
	private int selecionaMaior(T[] array,int leftIndex,int maior){
		int rightIndex = array.length-1;
		if(leftIndex< rightIndex){
			if(array[leftIndex+1].compareTo(array[maior]) >0){
				maior = leftIndex+1;
			}
			selecionaMaior(array, leftIndex+1, maior);
		}
		return maior;
	}

	private int selecionaMenor(T[] array,int leftIndex,int menor){
		int rightIndex = array.length-1;
		if(leftIndex< rightIndex){
			if(array[leftIndex+1].compareTo(array[menor]) <0){
				menor = leftIndex+1;
			}
			selecionaMenor(array, leftIndex+1, menor);
		}
		return menor;
	}

	private int selecionaMenorBase(T[] array,int leftIndex,int menor,int base){
		if(leftIndex < array.length){
			if(array[leftIndex].compareTo(array[menor]) < 0){
				if(array[leftIndex].compareTo(array[base]) > 0){
					menor = leftIndex;
				}
			}
			menor = selecionaMenorBase(array, leftIndex + 1, menor,base);
		}

		return menor;
	}
	
}
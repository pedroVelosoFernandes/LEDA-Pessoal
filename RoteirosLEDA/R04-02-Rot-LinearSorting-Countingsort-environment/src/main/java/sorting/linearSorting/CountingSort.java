package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex && leftIndex>= 0 && rightIndex<array.length){

			int[] C = new int[maiorIndex(array, leftIndex, rightIndex) + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]] += 1;
			}

			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			int[] B = new int[rightIndex - leftIndex + 1];

			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i]] - 1] = array[i];
				C[array[i]] -= 1;
			}
			int indice = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[indice];
				indice++;

			}
		}

	}
	private int maiorIndex(Integer[] array,int leftIndex,int rightIndex){
		int maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(maior)>0) {
				maior = array[i];
			}
		}
		return maior;
	}

}

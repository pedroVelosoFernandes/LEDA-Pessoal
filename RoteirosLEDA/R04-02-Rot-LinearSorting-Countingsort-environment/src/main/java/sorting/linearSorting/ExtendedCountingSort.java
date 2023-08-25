package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex && leftIndex>= 0 && rightIndex<array.length){
			int maiorElemento = maior(array, leftIndex, rightIndex);
			int menorElemento = menor(array, leftIndex, rightIndex);

			int[] C = new int[maiorElemento - menorElemento+1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				C[array[i]- menorElemento] += 1;
			}

			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			int[] B = new int[rightIndex - leftIndex + 1];

			for (int i = rightIndex; i >= leftIndex; i--) {
				B[C[array[i] - menorElemento] - 1] = array[i];
				C[array[i] - menorElemento] -= 1;
			}
			int indice = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[indice];
				indice++;

			}
		}

	}
	private int maior(Integer[] array,int leftIndex,int rightIndex){
		int maior = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(maior)>0) {
				maior = array[i];
			}
		}
		return maior;
	}
	private int menor(Integer[] array,int leftIndex,int rightIndex){
		int menor = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(menor)<0) {
				menor = array[i];
			}
		}
		return menor;
	}

}

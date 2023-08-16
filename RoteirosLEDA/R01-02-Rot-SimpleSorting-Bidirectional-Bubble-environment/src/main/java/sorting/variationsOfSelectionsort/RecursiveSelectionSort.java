package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length){

			int indexMenor = selecionaMenor(array, leftIndex+1, rightIndex,leftIndex);
			Util.swap(array,indexMenor, leftIndex);
			sort(array, leftIndex + 1, rightIndex);
		}
	}

	private int selecionaMenor(T[] array, int leftIndex, int rightIndex,int menor){
		int indexMenor = menor;
		if(array[indexMenor].compareTo(array[leftIndex]) > 0){
				indexMenor = leftIndex;
		}
		if(leftIndex < rightIndex){
			indexMenor = selecionaMenor(array, leftIndex + 1, rightIndex, indexMenor);
		}
		return indexMenor;
	}
}

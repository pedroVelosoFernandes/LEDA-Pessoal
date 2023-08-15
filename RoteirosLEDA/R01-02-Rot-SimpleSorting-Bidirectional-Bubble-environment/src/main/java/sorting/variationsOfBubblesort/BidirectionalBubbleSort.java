package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length){
			boolean trocas = true;
			while(trocas){
				//leva maior
				trocas = false;
				for(int i = leftIndex; i < rightIndex; i++){
					if(array[i].compareTo(array[i+1])> 0){
						Util.swap(array, i+1, i);
						trocas = true;
					}
				}
				//leva menor
				for(int j = rightIndex; j > leftIndex; j--){
					if(array[j].compareTo(array[j-1])< 0){
						Util.swap(array, j-1, j);
						trocas = true;
					}
				}
			}
		}
	}
}

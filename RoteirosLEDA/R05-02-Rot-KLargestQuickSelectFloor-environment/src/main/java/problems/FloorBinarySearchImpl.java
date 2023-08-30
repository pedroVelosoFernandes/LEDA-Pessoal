package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array != null && x > 0 && x <= array.length && array.length > 0){
			quickSort(array, 0, array.length-1);
			return floorRecursivo(array, x,0,array.length-1);
		}
		return null;

	}
	//[1,2,3,6,7,9] quero o 8
	private int floorRecursivo(Integer[] array,int x,int leftIndex,int rightIndex){
		int res = 0 ;
		if(array != null && x > 0 && x <= array.length && array.length > 0){
			if(leftIndex < rightIndex){
				int middle = (rightIndex+ leftIndex)/2;
				
				if(array[middle] == x || array[middle]< x && array[middle+1]>x){
					res = array[middle];
				}
				else if(array[middle].compareTo(x) > 0){
					res = floorRecursivo(array, x, leftIndex, middle-1);
				}
				else if(array[middle].compareTo(x) < 0){
					res = floorRecursivo(array, x, middle+1, rightIndex);
				}
			}
		}
		return res;
	}

	public void quickSort(Integer[] array,int leftIndex, int rightIndex){
		int pivot = particionar(array,leftIndex,rightIndex);
		quickSort(array, leftIndex, pivot-1);
		quickSort(array, pivot +1, rightIndex);
	}

	public int particionar(Integer[] array, int leftIndex,int rightIndex){
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for(int j = leftIndex; j<= rightIndex;j++){
			if(pivot.compareTo(array[j])>=0){
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

}

package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array != null && array.length > 0 && x != null){
			quickSort(array, 0, array.length-1);
			int floor = floorRecursivo(array, x,0,array.length-1,-1);
			if( floor != -1){
				return floor;
			}
		}
		return null;

	}
	private int floorRecursivo(Integer[] array,int x,int leftIndex,int rightIndex,Integer floor){
		Integer floorNumber = floor;
		if(leftIndex <= rightIndex){
			int mid = (leftIndex + rightIndex);
			
			if(array[mid] == x){
				floorNumber =  array[mid];
			}

			else if(x < array[mid]){
				floorNumber =  floorRecursivo(array, x, leftIndex, mid - 1, floorNumber);
			}
			else if(x > array[mid]){
				floorNumber =  floorRecursivo(array, x, mid + 1, rightIndex,array[mid]);
			}

		}
		return floorNumber;
	}

	private void quickSort(Integer[] array,int leftIndex, int rightIndex){
		if(leftIndex < rightIndex){
			int pivot = particionar(array,leftIndex,rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}
	}

	private int particionar(Integer[] array, int leftIndex,int rightIndex){
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for(int j = leftIndex+1; j<= rightIndex;j++){
			if(array[j].compareTo(pivot) <= 0){
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}
}

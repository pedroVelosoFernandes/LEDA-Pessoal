package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = null;
		if (array != null && array.length > 0 && x != null) {
			quickSort(array, 0, array.length - 1);
			floor = floorRecursivo(array, x, 0, array.length - 1);
		}
		return floor;

	}

	private Integer floorRecursivo(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer floorNumber = null;
		if (leftIndex <= rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;

			if (array[mid] == x) {
				floorNumber = array[mid];
			}

			else if (x < array[mid]) {
				floorNumber = floorRecursivo(array, x, leftIndex, mid - 1);
			} else if (x > array[mid]) {
				floorNumber = floorRecursivo(array, x, mid + 1, rightIndex);
			}

		} else {
			if (rightIndex < leftIndex) {
				if (rightIndex > -1 && array[rightIndex] < x) {
					floorNumber = array[rightIndex];
				}
			}
		}
		return floorNumber;
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = particionar(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}
	}

	private int particionar(Integer[] array, int leftIndex, int rightIndex) {
		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}
}
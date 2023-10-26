package adt.heap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class StudentMaxHeapTest {

	Heap<Integer> heap;

	@Before
	public void setUp() {
		// TODO Instancie seu comparator para fazer sua estrutura funcionar como
		// uma max heap aqui. Use instanciacao anonima da interface
		// Comparator!!!!
		Comparator<Integer> comparator = new ComparatorMaxHeap<>();
		heap = new HeapImpl<Integer>(comparator);
	}

	@Test
	public void testBuild() {
		heap.buildHeap(new Integer[] { 82, 6, 99, 12, 34, 64, 58, 1 });

		assertEquals(8, heap.size());
		assertFalse(heap.isEmpty());

		//verifyHeap(new Integer[] { 99, 12, 82, 6, 34, 64, 58, 1 });
		verifyHeap(new Integer[] { 99, 34, 82, 6, 12, 64, 58, 1 });
	}

	@Test
	public void testInsert() {
		heap.insert(8);
		heap.insert(12);
		heap.insert(-2);
		heap.insert(7);
		heap.insert(8);
		heap.insert(-5);
		heap.insert(14);
		heap.insert(3);
		heap.insert(-10);
		heap.insert(0);

		assertEquals(10, heap.size());
		assertFalse(heap.isEmpty());

		verifyHeap(new Integer[] { 14, 8, 12, 7, 8, -5, -2, 3, -10, 0 });
	}

	@Test
	public void testRemove() {
		heap.insert(22);
		heap.insert(45);
		heap.insert(38);
		heap.insert(17);
		heap.insert(40);
		heap.insert(15);
		heap.insert(26);
		heap.insert(79);
		heap.insert(53);
		heap.insert(30);

		assertEquals(new Integer(79), heap.extractRootElement());
		assertEquals(new Integer(53), heap.extractRootElement());
		assertEquals(new Integer(45), heap.extractRootElement());
		assertEquals(new Integer(40), heap.extractRootElement());
		assertEquals(new Integer(38), heap.extractRootElement());

		assertEquals(5, heap.size());
		assertFalse(heap.isEmpty());

		verifyHeap(new Integer[] { 22, 17, 15, 26, 30 });
	}

	@Test
	public void testSort() {
		assertArrayEquals(new Integer[] { 5, 6, 12, 20, 34, 43, 49, 92 },
				heap.heapsort(new Integer[] { 34, 92, 5, 12, 49, 20, 43, 6 }));

		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());

		assertArrayEquals(new Integer[] {}, heap.toArray());
	}

	private void verifyHeap(Integer[] expected) {
		boolean isHeap = true;

		Comparable<Integer>[] original = heap.toArray();

		Arrays.sort(expected);
		Arrays.sort(original);

		if (Arrays.equals(expected, original) == false)
			isHeap = false;

		original = heap.toArray();

		for (int i = 0; i < original.length; i++) {
			if (2 * i + 1 < original.length && original[i].compareTo((Integer) original[2 * i + 1]) < 0)
				isHeap = false;
			if (2 * i + 2 < original.length && original[i].compareTo((Integer) original[2 * i + 2]) < 0)
				isHeap = false;
		}

		assertTrue(isHeap);
	}
	private void verifyHeap(Heap<Integer> heap) {
		boolean isHeap = true;

		Comparable<Integer>[] original = heap.toArray();

		original = heap.toArray();

		for (int i = 0; i < original.length; i++) {
			if (2 * i + 1 < original.length && original[i].compareTo((Integer) original[2 * i + 1]) < 0)
				isHeap = false;
			if (2 * i + 2 < original.length && original[i].compareTo((Integer) original[2 * i + 2]) < 0)
				isHeap = false;
		}

		assertTrue(isHeap);
	}

	private Heap<Integer>  heapPar(){
		Heap<Integer> heap = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Integer[] heapA = new Integer[]{97, 89, 84, 67, 81, 61, 82, 30, 43, 12, 32, 37, 57, 31};

		heap.buildHeap(heapA);

		return heap;
	}

	private Heap<Integer>  heapUnica(){
		Heap<Integer> heap = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Integer[] heapA = new Integer[]{4};

		heap.buildHeap(heapA);

		return heap;
	}

	private Heap<Integer>  heapImpar(){
		Heap<Integer> heap = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Integer[] heapA = new Integer[]{4,5 ,6 ,7 ,8};

		heap.buildHeap(heapA);

		return heap;
	}

	private Heap<Integer> heapVazia(){
		Heap<Integer> heap = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Integer[] heapA = new Integer[]{};

		heap.buildHeap(heapA);

		return heap;
	}

	@Test
	public void testInsert1(){
		Heap<Integer> heap1 = this.heapPar();
		Heap<Integer> heap2 = this.heapImpar();
		Heap<Integer> heap3 = this.heapUnica();
		Heap<Integer> heap4 = this.heapVazia();

		verifyHeap(heap1);
		verifyHeap(heap2);
		verifyHeap(heap3);
		verifyHeap(heap4);

		int size1 = heap1.size();
		int size2 = heap2.size();
		int size3 = heap3.size();
		int size4 = heap4.size();

		for(int i = 0; i < 10; i++){
			heap1.insert(i);
			heap2.insert(i);
			heap3.insert(i);
			heap4.insert(i);
		}

		assertEquals(size1 + 10, heap1.size());
		assertEquals(size2 + 10, heap2.size());
		assertEquals(size3 + 10, heap3.size());
		assertEquals(size4 + 10, heap4.size());

		verifyHeap(heap1);
		verifyHeap(heap2);
		verifyHeap(heap3);
		verifyHeap(heap4);
	}

	@Test
	public void testBuild1(){
		Integer[] array1 = new Integer[]{};
		Integer[] array2 = new Integer[]{1};
		Integer[] array3 = new Integer[]{1, 3, 5,6 ,8 ,2 ,3, 8956, -98, -6325};
		Integer[] array4 = new Integer[]{80,4,95,7,65,25,78,94,6545};
		Integer[] array5 = new Integer[]{1};

		Heap<Integer> heap1 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Heap<Integer> heap2 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Heap<Integer> heap3 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Heap<Integer> heap4 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		Heap<Integer> heap5 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());

		heap1.buildHeap(array1);
		heap2.buildHeap(array2);
		heap3.buildHeap(array3);
		heap4.buildHeap(array4);
		heap5.buildHeap(array5);

		verifyHeap(heap1);
		verifyHeap(heap2);
		verifyHeap(heap3);
		verifyHeap(heap4);
		verifyHeap(heap5);
	}

	@Test
	public void testRemove1(){
		Heap<Integer> heap1 = this.heapPar();
		Heap<Integer> heap2 = this.heapImpar();
		Heap<Integer> heap3 = this.heapUnica();
		Heap<Integer> heap4 = this.heapVazia();

		Integer[] saidas1 = new Integer[]{97, 89, 84,82, 81, 67, 61,57,43,37, 32,31,  30, 12};
		Integer[] saidas2 = new Integer[]{8, 7, 6 ,5 ,4};

		for(int i : saidas1){
			assertTrue(i == heap1.extractRootElement());
		}

		for(int i : saidas2){
			assertTrue(i == heap2.extractRootElement());
		}

		assertTrue(4 == heap3.extractRootElement());
		assertTrue(null == heap1.extractRootElement());
		assertTrue(null == heap2.extractRootElement());
		assertTrue(null == heap3.extractRootElement());
		assertTrue(null == heap4.extractRootElement());

		assertTrue(0 == heap1.size());
		assertTrue(0 == heap2.size());
		assertTrue(0 == heap3.size());
		assertTrue(0 == heap4.size());
	}

	@Test
	public void testHeapSort(){
		Heap<Integer> heap1 = new HeapImpl<Integer>(new ComparatorMaxHeap<Integer>());
		
		Integer[] array1 = null;
		Integer[] array2 = new Integer[]{1};
		Integer[] array3 = new Integer[]{1, 3, 5,6 ,8 ,2 ,3, 8956, -98, -6325};
		Integer[] array4 = new Integer[]{80,4,95,7,65,25,78,94,6545};

		heap1.heapsort(array3);
		verifyHeap(heap1);
		heap1.heapsort(array4);
		verifyHeap(heap1);

		assertArrayEquals(heap1.heapsort(array2), array2);
		assertTrue(heap1.heapsort(array1)==null);
	}

}

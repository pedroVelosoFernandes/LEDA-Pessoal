package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();

		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();

	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).insertFirst(2);
		Assert.assertArrayEquals(new Integer[] { 2,4 }, lista2.toArray());
	}

	@Test
	public void testRemoveFirst() {
		lista2.insert(3);
		lista2.insert(2);
		lista2.insert(1);

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2,1 }, lista2.toArray());

		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista2.toArray());
		
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {  }, lista2.toArray());
		
		

		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemove1() {
		lista2.insert(1);
		lista2.insert(2);
		Assert.assertEquals(2, lista2.size());
		lista2.remove(2);
		Assert.assertEquals(1, lista2.size());
	}

	@Test
	public void testRemove() {

		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
	}
	@Test
	public void test01(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		listaTest.insert(null);
		listaTest.insertFirst(null);

		Assert.assertArrayEquals(new Integer[0], listaTest.toArray());
	}

	@Test
	public void test02(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		listaTest.insert(1);
		listaTest.insertFirst(0);
		listaTest.insert(2);
		listaTest.insertFirst(-1);
		listaTest.insert(2);
		listaTest.remove(2);

		Assert.assertTrue(listaTest.size() == 4);
		Assert.assertTrue(listaTest.search(3) == null);
		Assert.assertTrue(listaTest.search(2) == 2);
		
		
		Assert.assertArrayEquals(new Integer[]{-1, 0, 1, 2}, listaTest.toArray());
	}

	@Test
	public void test03(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		for(int i = 0; i <= 10; i++){
			listaTest.insertFirst(i);
		}

		for(int i = 0; i < 5; i++){
			listaTest.removeFirst();
			listaTest.removeLast();
		}

		listaTest.remove(456546);

		Assert.assertTrue(listaTest.size() == 1);
		Assert.assertTrue(listaTest.search(5) == 5);
		
		Assert.assertArrayEquals(new Integer[]{5}, listaTest.toArray());
	}

	@Test
	public void test04(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		listaTest.insert(7);
		listaTest.remove(456546);

		Assert.assertTrue(listaTest.size() == 1);
		Assert.assertTrue(listaTest.search(5) == null);
		
		Assert.assertArrayEquals(new Integer[]{7}, listaTest.toArray());
		listaTest.removeFirst();

		Assert.assertTrue(listaTest.size() == 0);
		Assert.assertTrue(listaTest.isEmpty());
	}

	@Test
	public void test05(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		listaTest.insert(7);
		listaTest.remove(456546);

		Assert.assertTrue(listaTest.size() == 1);
		Assert.assertTrue(listaTest.search(5) == null);
		
		Assert.assertArrayEquals(new Integer[]{7}, listaTest.toArray());
		listaTest.removeLast();

		Assert.assertTrue(listaTest.size() == 0);
		Assert.assertTrue(listaTest.isEmpty());
	}

	@Test
	public void test06(){
		DoubleLinkedList<Integer> listaTest = new DoubleLinkedListImpl<>();

		listaTest.remove(7);
		listaTest.removeFirst();
		listaTest.removeLast();

		listaTest.insert(7);
		listaTest.insertFirst(5);
		listaTest.removeFirst();
		Assert.assertArrayEquals(new Integer[]{7}, listaTest.toArray());

	}

	@Test
	public void test01Recursivo(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();

		listaTest.insert(null);
		listaTest.insertFirst(null);

		Assert.assertArrayEquals(new Integer[0], listaTest.toArray());
	}

	@Test
	public void test02Recursivo(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();

		listaTest.insert(1);
		listaTest.insertFirst(0);
		listaTest.insert(2);
		listaTest.insertFirst(-1);
		listaTest.insert(2);
		listaTest.remove(2);

		Assert.assertTrue(listaTest.size() == 4);
		Assert.assertTrue(listaTest.search(3) == null);
		Assert.assertTrue(listaTest.search(2) == 2);
		
		
		Assert.assertArrayEquals(new Integer[]{-1, 0, 1, 2}, listaTest.toArray());
	}

	@Test
	public void test03Recursivo(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();

		for(int i = 0; i <= 10; i++){
			listaTest.insertFirst(i);
		}

		for(int i = 0; i < 5; i++){
			listaTest.removeFirst();
			listaTest.removeLast();
		}

		listaTest.remove(456546);

		Assert.assertTrue(listaTest.size() == 1);
		Assert.assertTrue(listaTest.search(5) == 5);
		
		Assert.assertArrayEquals(new Integer[]{5}, listaTest.toArray());
	}

	@Test
	public void test04Recursivo(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();
		Assert.assertTrue(listaTest.isEmpty());
		Assert.assertTrue(listaTest.size() == 0);

		listaTest.insert(1);
		listaTest.insert(2);
		listaTest.insertFirst(0);
		listaTest.insertFirst(null);

		Assert.assertTrue(listaTest.size() == 3);
		Assert.assertArrayEquals(new Integer[]{0, 1, 2}, listaTest.toArray());

		listaTest.removeFirst();
		listaTest.removeLast();
		listaTest.remove(3);
		listaTest.remove(null);

		Assert.assertArrayEquals(new Integer[]{1}, listaTest.toArray());
	}

	@Test
	public void test05Rec(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();

		listaTest.insert(7);
		listaTest.remove(456546);

		Assert.assertTrue(listaTest.size() == 1);
		Assert.assertTrue(listaTest.search(5) == null);
		
		Assert.assertArrayEquals(new Integer[]{7}, listaTest.toArray());
		listaTest.removeLast();

		Assert.assertTrue(listaTest.size() == 0);
		Assert.assertTrue(listaTest.isEmpty());
	}

	@Test
	public void test06Rec(){
		DoubleLinkedList<Integer> listaTest = new RecursiveDoubleLinkedListImpl<>();

		listaTest.remove(7);
		listaTest.removeFirst();
		listaTest.removeLast();

		listaTest.insert(7);
		listaTest.insertFirst(5);
		listaTest.removeFirst();
		Assert.assertArrayEquals(new Integer[]{7}, listaTest.toArray());

	}
}
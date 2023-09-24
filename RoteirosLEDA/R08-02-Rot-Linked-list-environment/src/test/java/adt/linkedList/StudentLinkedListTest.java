package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new SingleLinkedListImpl<>();
		lista2 = new SingleLinkedListImpl<>();

		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();

	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		//Assert.assertEquals(3, lista1.size());
		lista2.insert(2);
		Assert.assertEquals(1, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {

		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
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
	public void test01(){
		LinkedList<Integer> lTest = new SingleLinkedListImpl<>();
		lTest.insert(null);

		Assert.assertTrue(lTest.size() == 0);
		lTest.insert(4);
		Assert.assertTrue(lTest.size() == 1);

		Assert.assertTrue(lTest.search(2) == null);
		Assert.assertTrue(lTest.search(4).equals(4));

		lTest.remove(7);
		Assert.assertTrue(lTest.size() == 1);

		lTest.remove(4);
		Assert.assertTrue(lTest.size() == 0);
		lTest.remove(55);
		Assert.assertTrue(lTest.size() == 0);

	}

	@Test
	public void test02(){
		LinkedList<Integer> lTest = new SingleLinkedListImpl<>();
		lTest.insert(null);


		lTest.insert(4);
		lTest.insert(5);
		lTest.insert(6);
		Assert.assertTrue(lTest.size() == 3);

		lTest.remove(6);

		Integer[] array = new Integer[]{4, 5};
		Assert.assertArrayEquals(array, lTest.toArray());
	}

	@Test
	public void test01Recursivo(){
		LinkedList<Integer> lTest = new RecursiveSingleLinkedListImpl<>();
		lTest.insert(null);


		lTest.insert(4);
		lTest.insert(5);
		lTest.insert(6);
		lTest.remove(88);
		Assert.assertTrue(lTest.size() == 3);

		lTest.remove(6);

		Integer[] array = new Integer[]{4, 5};
		Assert.assertArrayEquals(array, lTest.toArray());

		lTest.remove(5);
		array = new Integer[]{4};
		Assert.assertArrayEquals(array, lTest.toArray());

		lTest.remove(4);
		array = new Integer[]{};
		Assert.assertArrayEquals(array, lTest.toArray());
	}

	@Test
	public void test02Recursivo(){
		LinkedList<Integer> lTest = new RecursiveSingleLinkedListImpl<>();
		lTest.insert(null);

		Assert.assertTrue(lTest.size() == 0);
		lTest.insert(4);
		Assert.assertTrue(lTest.size() == 1);

		Assert.assertTrue(lTest.search(2) == null);
		Assert.assertTrue(lTest.search(4).equals(4));

		lTest.remove(7);
		Assert.assertTrue(lTest.size() == 1);

		lTest.remove(4);
		Assert.assertTrue(lTest.size() == 0);
		lTest.remove(55);
		Assert.assertTrue(lTest.size()==0);

	}
}
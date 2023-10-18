package adt.bst;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.extended.FloorCeilBST;
import adt.bst.extended.FloorCeilBSTImpl;
import adt.bt.BTNode;

public class StudentBSTTest {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
	//Arvore com um unico elemento 0
	private BST<Integer> tree1(){
		BST<Integer> tree = new BSTImpl<>();
		tree.insert(0);
		return tree;
	}

	//Arvore (caminho) de  1 a 10
	private BST<Integer> tree2(){
		BST<Integer> tree = new BSTImpl<>();
		for(int i = 1; i < 11; i++){
			tree.insert(i);
		}
		return tree;
	} 

	//https://prnt.sc/DuO0G4EpkQ2R
	private BST<Integer> tree3(){
		BST<Integer> tree = new BSTImpl<>();
		for(Integer i: new Integer[]{8, 4, 12, 2, 6 , 10, 14, 1, 3, 5, 7, 9, 11,13 ,15}){
			tree.insert(i);
		}
		return tree;
	}

	@Test
	public void testHeight1(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Assert.assertEquals(0, tree1.height());
		Assert.assertEquals(9, tree2.height());
		Assert.assertEquals(3, tree3.height());

		tree2.insert(15);
		tree2.insert(16);
		tree2.insert(14);

		Assert.assertEquals(11, tree2.height());

		tree2.insert(-98);

		Assert.assertEquals(11, tree2.height());

		for(int i = 1; i < 16; i+=2){
			tree3.remove(i);
		}

		Assert.assertEquals(2, tree3.height());

		tree1.remove(0);

		Assert.assertEquals(-1, tree1.height());
	}
	@Test
	public void testMaximumMinimum(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Assert.assertTrue(0 == tree1.maximum().getData());
		Assert.assertTrue(10 == tree2.maximum().getData());
		Assert.assertTrue(15 == tree3.maximum().getData());

		Assert.assertTrue(0 == tree1.minimum().getData());
		Assert.assertTrue(1 == tree2.minimum().getData());
		Assert.assertTrue(1 == tree3.minimum().getData());

		tree1.remove(0);
		
		Assert.assertTrue(null == tree1.minimum());
		Assert.assertTrue(null == tree1.maximum());

		for(int i = 15; i > 1; i--){
			tree3.remove(i);
			Assert.assertTrue(i - 1 == tree3.maximum().getData());;
		}

		for(int i = 1; i < 10 ; i++){
			tree2.remove(i);
			Assert.assertTrue(i + 1 == tree2.minimum().getData());;
		}
	}

	@Test
	public void testSucessor(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Integer[] tree2Resp = new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, null};
		Integer[] tree3Resp = new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, null};

		for(int i = 1; i <= 9; i++){
			Assert.assertEquals(tree2Resp[i -1], tree2.sucessor(i).getData());
		}

		Assert.assertEquals(null, tree2.sucessor(10));
		Assert.assertEquals(null, tree1.sucessor(0));

		for(int i = 1; i <= 14; i++){
			Assert.assertEquals(tree3Resp[i -1], tree3.sucessor(i).getData());
		}

		Assert.assertEquals(null, tree3.sucessor(15));
		Assert.assertEquals(null, tree3.sucessor(19999));
		Assert.assertEquals(null, tree3.sucessor(-15));
	}

	@Test
	public void testPredecessor(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();


		for(int i = 10; i >= 2; i--){
			Assert.assertTrue(i-1 == tree2.predecessor(i).getData());
		}

		Assert.assertEquals(null, tree2.predecessor(1));
		Assert.assertEquals(null, tree1.predecessor(0));

		for(int i = 15; i >= 2; i--){
			Assert.assertTrue(i-1 == tree3.predecessor(i).getData());
		}

		Assert.assertEquals(null, tree3.predecessor(1));
		Assert.assertEquals(null, tree3.predecessor(19999));
		Assert.assertEquals(null, tree3.predecessor(-15));
	}

	@Test
	public void testPreOrder(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Integer[] tree1R = new Integer[]{0};
		Integer[] tree2R = new Integer[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10};
		Integer[] tree3R = new Integer[]{8, 4, 2, 1, 3, 6 ,5 ,7 ,12 ,10, 9, 11, 14, 13 ,15};

		Assert.assertArrayEquals(tree1R, tree1.preOrder());
		Assert.assertArrayEquals(tree2R, tree2.preOrder());
		Assert.assertArrayEquals(tree3R, tree3.preOrder());

		tree1.remove(0);
		Assert.assertArrayEquals(new Integer[]{}, tree1.preOrder());
	}

	@Test
	public void testOrder(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Integer[] tree1R = new Integer[]{0};
		Integer[] tree2R = new Integer[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10};
		Integer[] tree3R = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

		Assert.assertArrayEquals(tree1R, tree1.order());
		Assert.assertArrayEquals(tree2R, tree2.order());
		Assert.assertArrayEquals(tree3R, tree3.order());

		tree1.remove(0);
		Assert.assertArrayEquals(new Integer[]{}, tree1.order());
	}

	@Test
	public void postOrder(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Integer[] tree1R = new Integer[]{0};
		Integer[] tree2R = new Integer[]{10, 9, 8, 7, 6, 5 ,4 ,3 ,2 ,1};
		Integer[] tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};

		Assert.assertArrayEquals(tree1R, tree1.postOrder());
		Assert.assertArrayEquals(tree2R, tree2.postOrder());
		Assert.assertArrayEquals(tree3R, tree3.postOrder());

		tree1.remove(0);
		Assert.assertArrayEquals(new Integer[]{}, tree1.postOrder());
	}

	@Test
	public void testSearch1(){
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();

		Assert.assertTrue(tree1.search(0).getData() == 0);

		for(int i = 1; i <= 10; i++){
			Assert.assertTrue(tree2.search(i).getData() == i);
		}

		for(int i = 1; i <= 15; i++){
			Assert.assertTrue(tree3.search(i).getData() == i);
			if(i > 1){
				Assert.assertTrue(tree1.search(i).equals(new BSTNode<Integer>()));
			}
			if(i > 10){
				Assert.assertTrue(tree2.search(i).equals(new BSTNode<Integer>()));
			}
		}
		assertTrue(tree2.search(null).equals(new BSTNode<Integer>()));
	}

	@Test
	public void testRemove1(){
		BST<Integer> tree3 = this.tree3();
		Integer[] tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 10, 13, 15, 14, 12, 9};

		//Removendo uma root:
		tree3.remove(8);
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(9);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 13, 15, 14, 12, 10};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(12);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 15, 14, 13, 10};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());

		//Removendo no so com um filho
		tree3.remove(14);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 15, 13, 10};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(13);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 15, 10};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(15);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11, 10};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(10);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4, 11};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(11);
		tree3R = new Integer[]{1, 3, 2, 5, 7, 6, 4};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());

		//Removendo folhas
		tree3.remove(1);
		tree3R = new Integer[]{3, 2, 5, 7, 6, 4};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(7);
		tree3R = new Integer[]{3, 2, 5, 6, 4};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(3);
		tree3R = new Integer[]{2, 5, 6, 4};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(5);
		tree3R = new Integer[]{2, 6, 4};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(4);
		tree3R = new Integer[]{2, 6};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(6);
		tree3R = new Integer[]{2};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		tree3.remove(2);
		tree3R = new Integer[]{};
		Assert.assertArrayEquals(tree3R, tree3.postOrder());
		Assert.assertTrue(tree3.isEmpty());

	}
	//Arvore (caminho) de  2 a 11
	private BST<Integer> tree4(){
		BST<Integer> tree = new BSTImpl<>();
		for(int i = 2; i < 12; i++){
			tree.insert(i);
		}
		return tree;
	} 

	@Test
	public void testEquals(){
		SimpleBSTManipulation<Integer> impl = new SimpleBSTManipulationImpl<>();
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();
		BST<Integer> tree3Copia = this.tree3();
		BST<Integer> tree4 = this.tree4();

		Assert.assertTrue(impl.equals(tree3Copia, this.tree3()));

		tree3Copia.remove(15);
		tree3Copia.insert(16);

		Assert.assertFalse(impl.equals(tree3Copia, tree3));

		Assert.assertTrue(impl.equals(tree1, this.tree1()));
		Assert.assertTrue(impl.equals(tree2, this.tree2()));
		Assert.assertTrue(impl.equals(tree3, this.tree3()));
		Assert.assertTrue(impl.equals(new BSTImpl<Integer>(), new BSTImpl<Integer>()));

		Assert.assertFalse(impl.equals(null, tree2));
		Assert.assertFalse(impl.equals(tree2, null));
		Assert.assertFalse(impl.equals(null, null));
		Assert.assertFalse(impl.equals(tree2, tree1));
		Assert.assertFalse(impl.equals(tree2, tree3));
		Assert.assertFalse(impl.equals(tree1, tree3));

		//mesmo formato, porem diferentes valores
		Assert.assertFalse(impl.equals(tree2, tree4));
	}

	@Test
	public void testSimilar(){
		SimpleBSTManipulation<Integer> impl = new SimpleBSTManipulationImpl<>();
		BST<Integer> tree1 = this.tree1();
		BST<Integer> tree2 = this.tree2();
		BST<Integer> tree3 = this.tree3();
		BST<Integer> tree3Copia = this.tree3();
		BST<Integer> tree4 = this.tree4();

		Assert.assertTrue(impl.equals(tree3Copia, this.tree3()));

		tree3Copia.remove(15);
		tree3Copia.insert(16);

		Assert.assertFalse(impl.equals(tree3Copia, tree3));
		Assert.assertTrue(impl.isSimilar(tree3Copia, tree3));
		
		Assert.assertFalse(impl.equals(tree2, tree4));
		Assert.assertTrue(impl.isSimilar(tree2, tree4));

		Assert.assertFalse(impl.isSimilar(null, tree2));
		Assert.assertFalse(impl.isSimilar(tree2, null));
		Assert.assertFalse(impl.isSimilar(null, null));
		Assert.assertFalse(impl.isSimilar(tree2, tree1));
		Assert.assertFalse(impl.isSimilar(tree2, tree3));
		Assert.assertFalse(impl.isSimilar(tree1, tree3));
		Assert.assertTrue(impl.isSimilar(new BSTImpl<Integer>(), new BSTImpl<Integer>()));

		Assert.assertTrue(impl.isSimilar(tree1, this.tree1()));
		Assert.assertTrue(impl.isSimilar(tree2, this.tree2()));
		Assert.assertTrue(impl.isSimilar(tree3, this.tree3()));
	}
	@Test
    public void testOrderStatics(){
        SimpleBSTManipulation<Integer> impl = new SimpleBSTManipulationImpl<>();
    
		BST<Integer> tree1 = this.tree1();
        BST<Integer> tree2 = this.tree2();
        BST<Integer> tree3 = this.tree3();

        for(int i = 1; i <= 15; i++){
            int k = impl.orderStatistic(tree3, i);
            Assert.assertEquals(i, k);
        }
    }
		@Test
	public void testFloor(){
		FloorCeilBST impl = new FloorCeilBSTImpl();
		
		Assert.assertTrue(0 == impl.floor(new Integer[]{-999999, 0, 99999}, 0));
		Assert.assertTrue(-15 == impl.floor(new Integer[]{-15, 0, 99999}, -1));
		Assert.assertTrue(0 == impl.floor(new Integer[]{-15, 0, 99999}, 1));
		Assert.assertTrue(null == impl.floor(new Integer[]{-15, 0, 99999}, -99999999));
		Assert.assertTrue(0 == impl.floor(new Integer[]{15}, 1));
		Assert.assertTrue(null == impl.floor(null, 1));
		Assert.assertTrue(15 == impl.floor(new Integer[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9 ,10}, 50));
	}

	@Test
	public void testCeil(){
		FloorCeilBST impl = new FloorCeilBSTImpl();
		Assert.assertTrue(0 == impl.ceil(new Integer[]{-999999, 0, 99999}, 0));
		Assert.assertTrue(0 == impl.ceil(new Integer[]{-999999, 0, 99999}, -1));
		Assert.assertTrue(-999999 == impl.ceil(new Integer[]{-999999, 0, 99999}, -99999999));
		Assert.assertTrue(99999 == impl.ceil(new Integer[]{-999999, 0, 99999}, 8));
		Assert.assertTrue(-999999 == impl.ceil(new Integer[]{-15, 0, 99999}, -99999999));
		Assert.assertTrue(null == impl.ceil(new Integer[]{}, 1));
		Assert.assertTrue(null == impl.ceil(null, 1));
		Assert.assertTrue(99999 == impl.ceil(new Integer[]{1, 2, 3, 4, 5, 6 ,7 ,8 ,9,10},50));

	}
	
}

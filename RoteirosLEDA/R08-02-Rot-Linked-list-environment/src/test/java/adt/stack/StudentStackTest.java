package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<>(4);
		stack2 = new StackDoubleLinkedListImpl<>(2);
		stack3 = new StackDoubleLinkedListImpl<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack2.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
	@Test
	public void test01(){
		Stack<Integer> s1 = new StackDoubleLinkedListImpl<>(0);
		assertTrue(s1.isEmpty());
		assertTrue(s1.isFull());
	}

	@Test
	public void test02(){
		try{
			Stack<Integer> s1 = new StackDoubleLinkedListImpl<>(2);
			assertTrue(s1.isEmpty());
			s1.push(null);
			assertTrue(s1.isEmpty());

		}
		catch(StackOverflowException e){
			e.printStackTrace();
		}
	}

	@Test
	public void test03(){
		try{
			Stack<Integer> s1 = new StackDoubleLinkedListImpl<>(1);

			assertTrue(s1.isEmpty());
			assertFalse(s1.isFull());

			s1.push(5);

			assertFalse(s1.isEmpty());
			assertTrue(s1.isFull());

		}
		catch(StackOverflowException e){
			e.printStackTrace();
		}
	}

	@Test
	public void test04(){
		try{
			Stack<Integer> q1 = new StackDoubleLinkedListImpl<>(5);

			assertTrue(q1.isEmpty());
			assertFalse(q1.isFull());

			for(int i = 1; i <= 5; i++){
				q1.push(i);
			}

			assertFalse(q1.isEmpty());
			assertTrue(q1.isFull());

			for(int i = 5; i >= 1; i--){
				assertTrue(i == q1.pop());
			}
	
			assertTrue(q1.isEmpty());
			assertFalse(q1.isFull());

		}
		catch(StackOverflowException | StackUnderflowException e){
			e.printStackTrace();
		}
	}
}
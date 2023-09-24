package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<Integer>(4);
		queue2 = new QueueDoubleLinkedListImpl<Integer>(2);
		queue3 = new QueueDoubleLinkedListImpl<Integer>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	@Test
	public void test01(){
		Queue<Integer> q1 = new QueueDoubleLinkedListImpl<>(0);
		assertTrue(q1.isEmpty());
		assertTrue(q1.isFull());
	}

	@Test
	public void test02(){
		try{
			Queue<Integer> q1 = new QueueDoubleLinkedListImpl<>(2);
			assertTrue(q1.isEmpty());
			q1.enqueue(null);
			assertTrue(q1.isEmpty());

		}
		catch(QueueOverflowException e){
			e.printStackTrace();
		}
	}

	@Test
	public void test03(){
		try{
			Queue<Integer> q1 = new QueueDoubleLinkedListImpl<>(1);

			assertTrue(q1.isEmpty());
			assertFalse(q1.isFull());

			q1.enqueue(5);

			assertFalse(q1.isEmpty());
			assertTrue(q1.isFull());

		}
		catch(QueueOverflowException e){
			e.printStackTrace();
		}
	}

	@Test
	public void test04(){
		try{
			Queue<Integer> q1 = new QueueDoubleLinkedListImpl<>(5);

			assertTrue(q1.isEmpty());
			assertFalse(q1.isFull());

			for(int i = 1; i <= 5; i++){
				q1.enqueue(i);
			}

			assertFalse(q1.isEmpty());
			assertTrue(q1.isFull());

			for(int i = 1; i <= 5; i++){
				assertTrue(i == q1.dequeue());
			}

			assertTrue(q1.isEmpty());
			assertFalse(q1.isFull());

		}
		catch(QueueOverflowException | QueueUnderflowException e){
			e.printStackTrace();
		}
	}
}
package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()){
			throw new QueueOverflowException();
		}
		else if(element != null){ 
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T res = null;
		if(this.isEmpty()){
			throw new QueueUnderflowException();
		}
		else{
			res = this.head();
			list.removeFirst();
		}
		return res;
	}

	@Override
	public T head() {
		return ((DoubleLinkedListImpl<T>) list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return 0 == list.size();
	}

	@Override
	public boolean isFull() {
		return this.size == list.size();
	}

}

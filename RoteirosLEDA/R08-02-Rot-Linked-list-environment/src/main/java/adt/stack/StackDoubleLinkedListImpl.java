package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.isFull()){
			throw new StackOverflowException();
		}
		else if(element != null){ 
			top.insert(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		T res = null;
		if(this.isEmpty()){
			throw new StackUnderflowException();
		}
		else{
			res = this.top();
			top.removeLast();
		}
		return res;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return 0 == top.size();
	}

	@Override
	public boolean isFull() {
		return this.size == top.size();
	}

}

package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>();
			node.setData(element);
			node.setNext(this.getHead());
			node.setPrevious(new DoubleLinkedListNode<>());
			node.getPrevious().setNext(node);

			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(node);

			if (this.getHead().isNIL()) {
				this.setLast(node);
			}
			this.setHead(node);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {

			if(this.getHead().getNext().isNIL()){
				this.getHead().setData(null);
			}
			else{
				this.setHead(this.getHead().getNext());
				
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.getHead()).getPrevious().setNext(this.getHead());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {

			if(this.getHead().getNext().isNIL()){
				this.getHead().setData(null);
			}
			else{

				this.setLast(this.getLast().getPrevious());

				this.getLast().setNext(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.getLast().getNext()).setPrevious(this.getLast());
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			newNode.setData(element);
			newNode.setPrevious(this.getLast());
			newNode.setNext(new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>) newNode.getNext()).setPrevious(newNode);

			this.getLast().setNext(newNode);

			if (this.getLast().isNIL()) {
				this.setHead(newNode);
			}
			this.setLast(newNode);
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				if (!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
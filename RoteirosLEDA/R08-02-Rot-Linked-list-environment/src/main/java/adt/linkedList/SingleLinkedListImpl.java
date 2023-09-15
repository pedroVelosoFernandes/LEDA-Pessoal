package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int res = 0;
		if(!this.isEmpty()){
			SingleLinkedListNode aux = this.getHead();
			while(!this.aux.isNIL()){
				size++;
				aux.getNext();
			}
		}
		return res;
	}

	@Override
	public T search(T element) {
		T res = null;
		if(element != null){
			if(!this.isEmpty()){
				SingleLinkedListNode aux = this.getHead();
				while(!this.aux.isNIL() && !this.aux.getData().equals(element)){
					aux = aux.getNext();
				}
				if(!this.aux.isNIL()){
					res = aux.getData();
				}
			}
		}
		return res;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(this.isEmpty()){
				this.setHead(new SingleLinkedListNode<T>(element, this.getHead()));
			}
			else{
				SingleLinkedListNode aux = this.getHead();
				while(!this.aux.getNext().isNIL()){
					aux = aux.getNext();
				}
				aux.setNext(new SingleLinkedListNode<T>(element, aux.getNext()));
			}
		}
	}
	//2 -> 3 - > 4 == 2 -> 4
	@Override
	public void remove(T element) {
		if(element != null){
			if(!this.isEmpty()){
				SingleLinkedListNode aux = this.getHead();
				while(!this.aux.isNIL() && !this.aux.getNext().getData().equals(element)){
					aux = aux.getNext();
				}
				if(!this.aux.isNIL()){
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode aux = this.getHead();
		T[] array = (T[]) new Comparable[this.size()];
		int contador = 0;

		while(!aux.isNIL()){
			array[contador++] = aux.getData();
			aux = aux.getNext();
		}
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

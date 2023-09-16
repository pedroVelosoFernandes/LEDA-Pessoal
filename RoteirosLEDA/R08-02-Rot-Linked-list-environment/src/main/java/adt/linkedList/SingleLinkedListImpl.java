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
		int size = 0;
		SingleLinkedListNode<T> aux = this.getHead();
		while(!aux.isNIL()){
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T src = null;
		if(element != null && !this.getHead().isNIL()){
			SingleLinkedListNode<T> aux = this.getHead();
			while(!aux.isNIL() && !aux.getData().equals(element)){
				aux = aux.getNext();
			}
			if(!aux.isNIL()){
				src = aux.getData();
			}
		}
		return src;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			SingleLinkedListNode<T> aux = this.getHead();
			if(this.isEmpty()){
				this.setHead(new SingleLinkedListNode<T>(element, this.getHead()));
			}
			else{

				while(!aux.isNIL()){
					aux = aux.getNext();
				}
				aux.setData(element);
				aux.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()){
			if(this.getHead().getData().equals(element)){
				this.setHead(this.getHead().getNext());
			}
			else{
				SingleLinkedListNode<T> aux = this.getHead();
				while(!aux.isNIL() && !aux.getNext().getData().equals(element)){
					aux = aux.getNext();
				}
				if(!aux.isNIL()){
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> aux = this.getHead();
		int contador = -1;
		T[] array = (T[]) new Comparable[this.size()];
		while(!aux.isNIL()){
			array[++contador] = aux.getData();
			aux = aux.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}

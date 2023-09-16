package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if(element != null){

			if(this.isEmpty()){
				
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
					
				this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
				this.getPrevious().setNext(this);
			}
			else if(this.getNext().isEmpty()){

				this.getNext().setData(element);
				this.getNext().setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
			else{
				this.getNext().insert(element);
			}
		}	
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			if(isEmpty()){
				this.insert(element);
			}
			else{

				RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<>();
				node.setData(this.getData());
				this.setData(element);

				node.setNext(this.getNext());
				node.setPrevious(this);

				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(node);
				this.setNext(node);
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(this.getNext().isEmpty()){
				this.setData(this.getNext().getData());
			}
			else{
				T dado = this.getData();
				this.setData(this.getNext().getData());
				this.getNext().setData(dado);
				
				this.setNext(this.getNext().getNext());
				if(!this.getNext().isEmpty()){
					((RecursiveDoubleLinkedListImpl<T>)this.getNext().getNext()).setPrevious(this);
				}
			}


		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()){
			if(this.getNext().isEmpty()){
				this.setData(this.getNext().getData());
				this.setNext(this.getNext());
			}
			else{
				((RecursiveDoubleLinkedListImpl<T>)this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}

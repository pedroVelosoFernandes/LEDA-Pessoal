package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.getRoot()) -1;
	}

	private int height(BSTNode<T> node){
		int h = 0;
		if(!node.isEmpty()){
			h += 1;
			int hLeft = height((BSTNode<T>) node.getLeft());
			int hRight = height((BSTNode<T>) node.getRight());
			if(hLeft < hRight){
				h += hRight;
			}
			else{
				h += hLeft;
			}
		}
		return h;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element,this.getRoot());	
	}
	private BSTNode<T> search(T element,BSTNode<T> node){
		
		BSTNode<T> res = new BSTNode<>();

		if(element != null){
			if(node.isEmpty() || node.getData().compareTo(element) == 0){
				res = node;
			}
			else if (node.getData().compareTo(element) > 0){
				res = this.search(element,(BSTNode<T>) node.getLeft());
			}
			else{
				res = this.search(element,(BSTNode<T>) node.getRight());
			}
		}
		return res;
	}


	@Override
	public void insert(T element) {
		if(element != null){
			insert(this.getRoot(),element);
		}
	}
	private void insert(BSTNode<T> node,T element){
		if( node.isEmpty()){

			node.setData(element);
			node.setLeft(new BSTNode<>());
			node.setRight(new BSTNode<>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		else{
			if(element.compareTo(node.getData()) < 0){
				insert((BSTNode<T>)node.getLeft(), element);
			}
			else if ( element.compareTo(node.getData()) > 0){
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.getRoot());
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> aux = node;
		if(aux.isEmpty()){
			aux = null;
		}
		else{
			while(!aux.getRight().isEmpty()){
				aux = (BSTNode<T>) aux.getRight();
			}
		}
		return aux;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.getRoot());
	}
	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> aux = node;
		if(aux.isEmpty()){
			aux = null;
		}
		else{
			while(!aux.getLeft().isEmpty()){
				aux = (BSTNode<T>) aux.getLeft();
			}
		}
		return aux;
	}

	@Override
    public BSTNode<T> sucessor(T element) {
        BSTNode<T> resp = null;
        BSTNode<T> node = search(element);

        if(!node.isEmpty()){
            if(!node.getRight().isEmpty()){
				resp = this.minimum((BSTNode<T>) node.getRight());
            }
            else{
                resp = this.sucessor(node);
            }
        }
        return resp;
    }

    private BSTNode<T> sucessor(BSTNode<T> node){
        BSTNode<T> resp = (BSTNode<T>) node.getParent();

        if(node.getParent() != null && !resp.isEmpty() && node.equals(resp.getRight())){
            resp = this.sucessor(resp);
        }

        return resp;
    }

	@Override
    public BSTNode<T> predecessor(T element) {
        BSTNode<T> resp = null;
        BSTNode<T> node = search(element);

        if(!node.isEmpty()){
            if(!node.getLeft().isEmpty()){
                resp = this.maximum((BSTNode<T>) node.getLeft());
            }
            else{
                resp = this.predecessor(node);
            }
        }
        return resp;
    }

    private BSTNode<T> predecessor(BSTNode<T> node){
        BSTNode<T> y = (BSTNode<T>) node.getParent();

        if(node.getParent() != null && !y.isEmpty() && node.equals(y.getLeft())){
            y = this.predecessor(y);
        }

        return y;
    }

	@Override
	public void remove(T element) {
		remove(search(element));
	}
	private void remove(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.isLeaf()){
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
			}
			else if( node.getRight().isEmpty() || node.getLeft().isEmpty()){
				if(!node.equals(this.getRoot())){
					if(node.getParent().getData().compareTo(node.getData())> 0){
						if(!node.getLeft().isEmpty()){
							node.getLeft().setParent(node.getParent());
							node.getParent().setLeft(node.getLeft());
						}
						else{
							node.getRight().setParent(node.getParent());
							node.getParent().setLeft(node.getRight());
						}
					}
					else{
						if(!node.getLeft().isEmpty()){
							node.getLeft().setParent(node.getParent());
							node.getParent().setRight(node.getLeft());
						}
						else{
							node.getRight().setParent(node.getParent());
							node.getParent().setRight(node.getRight());
						}
					}
				}
				else{
					if(!node.getLeft().isEmpty()){
						this.root = (BSTNode<T>) node.getLeft();
					}
					else{
						this.root = (BSTNode<T>) node.getRight();
					}
					this.root.setParent(null);
				}
			}
			else{
				BSTNode<T> sucessor = sucessor(node.getData());
				T tmp = sucessor.getData();
				this.remove(sucessor);
				node.setData(tmp);
			}
		}
	}

	private int visit(T[] array,T elemento,int indice){
		array[indice++] = elemento;
		return indice;
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		preOrder(this.getRoot(),array,0);
		return array;
	}
	private int preOrder(BSTNode<T> node,T[] array,int indice){
		if(node != null && !node.isEmpty()){
			indice = visit(array,node.getData(),indice);
			indice = preOrder((BSTNode<T>) node.getLeft(), array, indice);
			indice = preOrder((BSTNode<T>) node.getRight(), array, indice);
		}
		return indice;
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];
		order(this.getRoot(),array,0);
		return array;
	}

	private int order(BSTNode<T> node,T[] array,int indice){
		if(node != null && !node.isEmpty()){
			indice = order((BSTNode<T>) node.getLeft(), array, indice);
			indice = visit(array,node.getData(),indice);
			indice = order((BSTNode<T>) node.getRight(), array, indice);
		}
		return indice;
	}

	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		postOrder(this.getRoot(),array,0);
		return array;
	}

	private int postOrder(BSTNode<T> node,T[] array,int indice){
		if(node != null && !node.isEmpty()){
			indice = postOrder((BSTNode<T>) node.getLeft(), array, indice);
			indice = postOrder((BSTNode<T>) node.getRight(), array, indice);
			indice = visit(array,node.getData(),indice);
		}
		return indice;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int result = 0;

		if (!node.isEmpty()) {
			result = this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		}
		return result;
	}
	

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = this.calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (this.calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = Util.rightRotation(node);
				} else {
					newRoot = Util.doubleRightRotation(node);
				}

			} else {
				if (this.calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = Util.leftRotation(node);
				} else {
					newRoot = Util.doubleLeftRotation(node);
				}
			}

		}
		if (this.getRoot().equals(node) && newRoot != null) {
			this.root = newRoot;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			this.rebalance((BSTNode<T>) node.getParent());
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
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
	public void insert(T element) {
		if(element != null){
			insert(this.getRoot(),element);
		}
	}
	private void insert(BSTNode<T> node,T element){
		if( node.isEmpty()){

			node.setData(element);
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
		}
		else{
			if(element.compareTo(node.getData()) < 0){
				insert((BSTNode<T>)node.getLeft(), element);
			}
			else if ( element.compareTo(node.getData()) > 0){
				insert((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
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
				rebalanceUp(node);
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
				rebalanceUp(node);
			}
			else{
				BSTNode<T> sucessor = sucessor(node.getData());
				T tmp = sucessor.getData();
				this.remove(sucessor);
				node.setData(tmp);
			}
		}
	}
}

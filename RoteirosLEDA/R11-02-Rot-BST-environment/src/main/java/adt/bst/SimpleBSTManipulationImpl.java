package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean resp = false;
		if(tree1 != null && tree2 != null){
			resp = this.equals((BSTNode<T>) tree1.getRoot(),(BSTNode<T>) tree2.getRoot());
		}
		return resp;
	}
	private boolean equals(BSTNode<T> node1,BSTNode<T> node2){
		boolean resp = false;
		if(!node1.isEmpty() && !node2.isEmpty()){
			resp = node1.equals(node2) 
					&& this.equals((BSTNode<T>)node1.getLeft(),(BSTNode<T>) node2.getLeft())
					&& this.equals((BSTNode<T>)node1.getRight(),(BSTNode<T>) node2.getRight());
		}
		else{
			resp = node1.equals(node2);
		}
		return resp;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean resp = false;
		if(tree1 != null && tree2 != null){
			resp = this.isSimilar((BSTNode<T>) tree1.getRoot(),(BSTNode<T>) tree2.getRoot());
		}
		return resp;
	}
	private boolean isSimilar(BSTNode<T> node1,BSTNode<T> node2){
		boolean resp = false;
		if(!node1.isEmpty() && !node2.isEmpty()){
			resp =  this.isSimilar((BSTNode<T>)node1.getLeft(),(BSTNode<T>) node2.getLeft())
					&& this.isSimilar((BSTNode<T>)node1.getRight(),(BSTNode<T>) node2.getRight());
		}
		else{
			resp = node1.equals(node2);
		}
		return resp;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T res = null;
		if(k > tree.size() || k <= 0){
			res = null;
		}
		else{
			res = orderStatistic((BSTNode<T>)tree.getRoot(), k);
		}
		return res;
	}
	public T orderStatistic(BSTNode<T> node, int k) {
		T res = null;
		int sizeEsquerda = size((BSTNode<T>) node.getLeft());

		if(sizeEsquerda + 1 == k){
			res = node.getData();
		}
		else if(k <= sizeEsquerda){
			res = orderStatistic((BSTNode<T>)node.getLeft(), k);
		}
		else{
			res = orderStatistic((BSTNode<T>)node.getRight(), k - (sizeEsquerda  + 1));
		}
		return res;
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		if (!node.isEmpty()) { 
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

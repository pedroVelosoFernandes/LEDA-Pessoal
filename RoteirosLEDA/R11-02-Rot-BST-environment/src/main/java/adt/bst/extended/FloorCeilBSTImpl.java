package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
	
		if(array != null){
			for (Integer i : array){
				this.insert(i);
			}
		}
		return floor(this.getRoot(),numero,null);
	}
	private Integer floor(BSTNode<Integer> node, double numero,Integer floor){
		if(!node.isEmpty()){
			if(node.getData() == numero){
				floor = node.getData();
			}
			else if(node.getData() > numero){
				floor = floor((BSTNode<Integer>)node.getLeft(), numero, floor);
			}
			else{
				floor = floor((BSTNode<Integer>)node.getRight(),numero, node.getData());
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if(array != null){
			for (Integer i : array){
				this.insert(i);
			}
		}
		return ceil(this.getRoot(),numero,null);
	}

	private Integer ceil(BSTNode<Integer> node, double numero,Integer ceil){
		if(!node.isEmpty()){
			if(node.getData() == numero){
				ceil = node.getData();
			}
			else if(node.getData() > numero){
				ceil = ceil((BSTNode<Integer>)node.getLeft(), numero, node.getData());
			}
			else{
				ceil = ceil((BSTNode<Integer>)node.getRight(),numero, ceil);
			}
		}
		return ceil;
	}

}

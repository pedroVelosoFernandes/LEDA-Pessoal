package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] resposta = (T[]) new Comparable[k];
		//[2,3,4,5,6,7] -> [4,5,6,7]
		if(array != null && k > 0 && k <= array.length && array.length > 0){

			int count = k-1;
			
			for(int i = array.length; i> k-array.length ;i--){
				resposta[count--] = orderStatistics(array, i);
				k++;
			}
		}
		else{
			resposta = (T[]) new Comparable[0];
		}
		return resposta;
		//este metodo deve obrigatoriamente usar o orderStatistics abaixo.
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T res = null;
		if(array != null && k > 0 && k <= array.length && array.length > 0){
			int index = quick(array,0,array.length-1,k);
			res = array[index];
		}
		return res;
	}
	private int quick(T[] array, int leftIndex, int rightIndex,int k){
		int indexPivot = particionar(array, leftIndex, rightIndex);
		

		if(indexPivot + 1 < k){
			indexPivot = quick(array, indexPivot + 1, rightIndex,k);
		}
		if(indexPivot + 1 > k){
			indexPivot = quick(array,leftIndex, indexPivot-1,k);
		}
		return indexPivot;

	}
	private int particionar(T[] array,int leftIndex,int rightIndex){

		T pivot = array[leftIndex];
		int i = leftIndex;
		for(int j = i +1;j< rightIndex;j++){
			if(array[j].compareTo(pivot)<=0){
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
	
		return i;
	}
}

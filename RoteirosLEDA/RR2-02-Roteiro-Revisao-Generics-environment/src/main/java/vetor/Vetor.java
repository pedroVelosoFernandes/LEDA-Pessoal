package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>>{

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T res = null;
		boolean achou = false;
		int i = 0;
		while(i <= indice && !achou){
			if(arrayInterno[i].equals(o)){
				res = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}

		return res;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T res = null;
		boolean achou = false;
		int i = 0;
		while(i <= indice && !achou){
			if(arrayInterno[i].equals(o)){
				res = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return res;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return indice == tamanho -1;
	}
	
	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

	public T minimo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}


	class ComparadorMaximo implements Comparator<Aluno> {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return (int) (o1.getMedia() - o2.getMedia());
		}
	
	}
	
	class ComparadorMinimo implements Comparator<Aluno> {
	
		@Override
		public int compare(Aluno o1, Aluno o2) {
			return (int) (o2.getMedia() - o1.getMedia());
		}
	
	}
}

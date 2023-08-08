package produto;

import java.util.ArrayList;

import produto.Produto;

public class RepositorioProdutosArray<T extends Produto> implements RepositorioProdutos<T> {
    /**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	private T[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProdutosArray(int size) {
		super();
		this.produtos = (T[]) new Object[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		int i = 0;
		int resp = -1;
		boolean achou = false;

		while ((i <= index) && !achou) {
			if (produtos[i].getCodigo() == codigo) {
				resp = i;
				achou = true;
			}
			i = i + 1;
		}
		return resp;

	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		boolean res = false;

		if(procurarIndice(codigo) == -1){
			res = true;
		}

		return res;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(T produto) {
		produtos[++ index] = produto;
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(T produto) {
		if(procurarIndice(produto.getCodigo()) == -1) throw new RuntimeException(); 
		int i = procurarIndice(produto.getCodigo());
		if (i != -1) {
			produtos[i] = produto;
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			produtos[i] = produtos[index];
			produtos[index] = null;
			index--;
		} else {
			throw new RuntimeException("Produto nao encontrado");
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public T procurar(int codigo) {
		int index = procurarIndice(codigo);
		if(index == -1) throw new RuntimeException();
		return produtos[index];
	}
}

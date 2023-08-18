package sorting.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new BubbleSort<Integer>();
		this.implementation = new InsertionSort<Integer>();
		this.implementation = new SelectionSort<Integer>();
		this.implementation = new BidirectionalBubbleSort<Integer>();
		this.implementation = new RecursiveBubbleSort<Integer>();
		this.implementation = new RecursiveSelectionSort<Integer>();
		
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	public void genericTestPedaco(Integer[] array,int leftIndex,int rightIndex) {
		Integer[] copy1 = {}; 

		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
			Arrays.sort(copy1,leftIndex,rightIndex+1);
		}
		implementation.sort(array,leftIndex,rightIndex);
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort6(){
		//par
		Integer[] vetor = new Integer[]{2,6,4,3};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 3);
	}
	@Test
	public void testSort7(){
		//impar
		Integer[] vetor = new Integer[]{4,3,1};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 2);
	}
	@Test
	public void testSort8(){
		//caso base
		Integer[] vetor = new Integer[]{1};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 0);
	}
	@Test
	public void testSort9(){
		//lista ordenada
		Integer[] vetor = new Integer[]{4 ,5, 6 ,7};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 3);
	}
	@Test
	public void testSort10(){
		//troca dos limites da lista
		Integer[] vetor = new Integer[]{4,2,3,0};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 3);
	}
	@Test
	public void testSort11(){
		//vazia
		Integer[] vetor = new Integer[]{};
		genericTest(vetor);
		genericTestPedaco(vetor, 0, 0);
	}
	@Test
	public void testSort12(){
		//parte
		Integer[] vetor = new Integer[]{7,6,5,4,3,2,1};
		//esperado ind[2](elemento 5) ate ind[4](elemento3) estarem ordenados
		genericTestPedaco(vetor,2,4);
	}
	@Test
	public void testSort13(){
		//index esquerdo e direito 0
		Integer[] vetor = new Integer[]{0,1};
		genericTestPedaco(vetor,0,0);
	}
	@Test
	public void testSort14(){
		//index esquerdo e direito -1
		Integer[] vetor = new Integer[]{0,1};
		genericTestPedaco(vetor,0,-1);
	}
	
	@Test
	public void testSort15(){
		//index esquerdo > direito
		Integer[] vetor = new Integer[]{0,1};
		genericTestPedaco(vetor,2,1);
	}
	@Test
	public void testSort16(){
		//negativos
		Integer[] vetor = new Integer[]{-2,-1};
		genericTest(vetor);
		genericTestPedaco(vetor,2,1);
	}
}
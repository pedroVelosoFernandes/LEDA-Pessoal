package recursao;

import java.util.Arrays;

public class GeradorSequencia {
	public void geraSequencia1(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			System.out.print(n + " ");
			geraSequencia1(n - 1);
		}
	}

	public void geraSequencia2(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			// A ORDEM DOS COMANDOS NA RECURSÃO ESTÁ INVERTIDA
			// VEJA O EFEITO E TENTE ENTENDER O PORQUE DISSO
			geraSequencia2(n - 1);
			System.out.print(n + " ");
		}
	}
	public int calcularSomaArray(int[] array){
		int result = 0;
		//enquanto o tamanho do array nao for 0, adiciona o primeiro, exclui o ultimo primeiro termo
		if(array.length == 1){
			result = array[0];
		}
		else{
			result = array[0] + calcularSomaArray(Arrays.copyOfRange(array,1,array.length));
		}
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		if(n == 1){
			result = 1;
		}
		else{
			result = n * calcularFatorial(n-1);
		}
		return result;
	}
	public int calcularFibonacci(int n) {
		int result = 1;
		if (n <= 2) {
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}

		return result;
	}
	public int countNotNull(Object[] array) {
		int result = 0;
		if(array.length == 1){
			if(array[0] != null) result++;
		}
		else{
			if(array[0] != null) result++;
			result += countNotNull(Arrays.copyOfRange(array,1,array.length));
		}
	
		return result;
	}
	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente != 1){
			result = 2 * potenciaDe2(expoente-1);
		}
		return result;
	}
	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		if(n > 1){
			result = progressaoAritmetica(termoInicial + razao, razao, n-1);
		}
		else{
			result = termoInicial;
		}
		return result;
	}
	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		if(n > 1){
			result = progressaoGeometrica(termoInicial * razao, razao, n-1);
		}
		else{
			result = termoInicial;
		}
		return result;
	}
	
	public static void main(String[] args) {
		GeradorSequencia gs = new GeradorSequencia();
		System.out.println(gs.progressaoAritmetica(1, 5, 1));
		System.out.println(gs.progressaoAritmetica(2, 2, 4));
		System.out.println(gs.progressaoGeometrica(2, 2, 4));
		System.out.println(gs.progressaoGeometrica(1, 5, 1));
	}
}

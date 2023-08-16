package vetor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Vetortesteteste {

	private Vetor<Aluno> vetor;

	@Before
	public void setUp() throws Exception {
		vetor = new Vetor<Aluno>(10);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);
	}
	@Test
	public void testInserir() {
		assertTrue(vetor.isVazio());
		vetor.inserir(new Aluno("Joao Epifanio", 5.0));
		assertFalse(vetor.isVazio());

	}

	@Test
	public void testRemover() {
		Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
		vetor.inserir(novoAluno);
		assertFalse(vetor.isVazio());
		vetor.remover(novoAluno);
		assertTrue(vetor.isVazio());
	}

	@Test
	public void testProcurar() {
		Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
		vetor.inserir(novoAluno);

		Aluno procurado = vetor.procurar(novoAluno);
		assertEquals(novoAluno, procurado);
		procurado = vetor.procurar(new Aluno("Ze", 6.0));
		assertNull(procurado);
	}

	@Test
	public void testIsCheio() {
		for (int i = 0; i < 10; i++) {
			Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
			vetor.inserir(novoAluno);
		}
		assertTrue(vetor.isCheio());
	}

	@Test
	public void testMaximo() {
		Aluno novoAluno1 = new Aluno("Joao Epifanio", 5.0);
		Aluno novoAluno2 = new Aluno("Jose Laurentino", 6.0);
		vetor.inserir(novoAluno1);
		vetor.inserir(novoAluno2);
		Aluno maximo = vetor.maximo();
		assertEquals(novoAluno2, maximo);
	}

	@Test
	public void testMinimo() {
		Aluno novoAluno1 = new Aluno("Joao Epifanio", 5.0);
		Aluno novoAluno2 = new Aluno("Jose Laurentino", 6.0);
		vetor.inserir(novoAluno1);
		vetor.inserir(novoAluno2);
		Aluno minimo = vetor.minimo();
		assertEquals(novoAluno1, minimo);
	}
}

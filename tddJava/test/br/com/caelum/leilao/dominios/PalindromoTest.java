package br.com.caelum.leilao.dominios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominios.Palindromo;

public class PalindromoTest {
	
	private Palindromo palindromo;

	@Before
	public void build() {
		palindromo = new Palindromo();
	}

	@Test
	public void testePalindromo() {
		Assert.assertTrue(palindromo.ehPalindromo("Arara"));
		Assert.assertTrue(palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos"));
		Assert.assertTrue(palindromo.ehPalindromo("Anotaram a data da maratona"));

	}

	@Test
	public void deveIdentificarSeNaoEhPalindromo() {
		Assert.assertFalse(palindromo.ehPalindromo("E preciso amar as pessoas como se nao houvesse amanha"));
	}

}

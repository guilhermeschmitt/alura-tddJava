package br.com.caelum.leilao.dominios;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AnoBissextoTest {
	
	private AnoBissexto anoBissexto;

	@Before
	public void build() {
		anoBissexto = new AnoBissexto();
	}

	@Test
	public void calculaAnoBissextoDeAnoMultiploDe400() {
		
		assertTrue(anoBissexto.ehBissexto(400));
	}
	
	@Test
	public void calculaAnoBissextoDeAnoQueNaoEhMultiploDe400MasDe100() {
		assertFalse(anoBissexto.ehBissexto(300));
	}
	
	@Test
	public void calculaAnoBissextoDeAnoQueEhMultiploDeQuatro() {
		assertTrue(anoBissexto.ehBissexto(80));
	}
	
	@Test
	public void naoEhAnoBissexto() {
		assertFalse(anoBissexto.ehBissexto(2017));
	}
}

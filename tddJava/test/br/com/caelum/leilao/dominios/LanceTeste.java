package br.com.caelum.leilao.dominios;

import org.junit.Before;
import org.junit.Test;

public class LanceTeste {

	private Usuario usuario;

	@Before
	public void build() {
		usuario = new Usuario("joao");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRecusarComValoresNegativos() {
		new Lance(usuario, -1.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveRecusarComValorZero() {
		new Lance(usuario, 0.0);
	}

}

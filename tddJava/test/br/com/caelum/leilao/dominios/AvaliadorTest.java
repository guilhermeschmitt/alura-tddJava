package br.com.caelum.leilao.dominios;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominios.Avaliador;
import br.com.caelum.leilao.dominios.Lance;
import br.com.caelum.leilao.dominios.Leilao;
import br.com.caelum.leilao.dominios.Usuario;

public class AvaliadorTest {
	
	private Avaliador leiloeiro;
	private Leilao leilao;
	private Usuario joao;
	private Usuario maria;
	private Usuario gabriel;
	private Lance lanceJoao;
	private Lance lanceMaria;
	private Lance lanceGabriel;
	private Lance lanceJoao2;
	private Lance lanceGabriel2;

	@Before
	public void build() {
		joao = new Usuario("joão");
		maria = new Usuario("maria");
		gabriel = new Usuario("gabriel");
		
		lanceJoao = new Lance(joao, 300.0);
		lanceMaria = new Lance(maria, 250.0);
		lanceGabriel = new Lance(gabriel, 490.0);
		lanceJoao2 = new Lance(joao, 900.0);
		lanceGabriel2 = new Lance(gabriel, 800.0);
		
		leilao = new Leilao("Leilão de um PS4 que não funciona");
		
		leiloeiro = new Avaliador();
	}

	@Test
	public void avaliaComVariosLances() {
		leilao.propoe(lanceJoao);
		leilao.propoe(lanceMaria);
		leilao.propoe(lanceGabriel);
		leiloeiro.avalia(leilao);
		assertEquals(490.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(250.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void avaliaComUmUnicoLance() {
		leilao.propoe(lanceJoao);
		leiloeiro.avalia(leilao);
		assertEquals(300.0, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
	}
	
	@Test
	public void calculaMediaComVariosLances() {
		leilao.propoe(lanceJoao);
		leilao.propoe(lanceMaria);
		leilao.propoe(lanceGabriel);
		leiloeiro.calculaLanceMedio(leilao);
		assertEquals(((300.0+250.0+490.0)/3), leiloeiro.getLanceMedio() , 0.0001);
	}
	
	
	public void calculaLanceSemLance() {
        leiloeiro.calculaLanceMedio(leilao);
        assertEquals(0.0, leiloeiro.getLanceMedio(), 0.0001);
	}
	
	@Test
	public void pegaTresMaioresComCincoLances() {

		leilao.propoe(lanceJoao);
		leilao.propoe(lanceMaria);
		leilao.propoe(lanceGabriel);
		leilao.propoe(lanceJoao2);
		leilao.propoe(lanceGabriel2);
				
		leiloeiro.avalia(leilao);
		assertEquals(3, leiloeiro.getTresMaiores().size());
		assertThat(leiloeiro.getTresMaiores(), hasItems(
				new Lance(joao,  900.0),
				new Lance(gabriel, 800.0),
				new Lance(gabriel, 490.0)));

	}
	
	@Test
	public void pegaTresMaioresComDoisLances() {
		leilao.propoe(lanceJoao);
		leilao.propoe(lanceMaria);
		
		leiloeiro.avalia(leilao);
		assertEquals(2,  leiloeiro.getTresMaiores().size());
		assertEquals(300.0, leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
		assertEquals(250.0, leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
	}
	
	@Test(expected=RuntimeException.class)
	public void pegaTresMaioresComNenhumLance() {	
		leiloeiro.avalia(leilao);
        //assertEquals(0, leiloeiro.getTresMaiores().size());
	}
	
}

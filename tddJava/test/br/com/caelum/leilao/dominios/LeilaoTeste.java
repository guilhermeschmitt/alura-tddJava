package br.com.caelum.leilao.dominios;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.LeilaoBuilder;

public class LeilaoTeste {
	
	private Leilao leilao;
	private Usuario steveJobs;
	private Usuario billGates;
	private LeilaoBuilder leilaoBuilder;

	@Before
	public void build() {
		leilao = new Leilao("Macbook Pro 15");
		steveJobs = new Usuario("Steve Jobs");
		billGates = new Usuario("Bill Gates");
		leilaoBuilder = new LeilaoBuilder(leilao);
	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		
		leilao = leilaoBuilder
				.lance(steveJobs, 2000.0)
				.lance(steveJobs, 3000.0)
				.constroi();
		
        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
    
	}
	
	@Test
	public void naoDeveAceitarCincoLancesDeUmMesmoUsuario() {
		
		leilao = leilaoBuilder
					.lance(steveJobs, 2000.0)
					.lance(billGates, 3000.0)
					.lance(steveJobs, 4000.0)
					.lance(billGates, 5000.0)
					.lance(steveJobs, 6000.0)
					.lance(billGates, 7000.0)
					.lance(steveJobs, 8000.0)
					.lance(billGates, 9000.0)
					.lance(steveJobs, 10000.0)
					.lance(billGates, 11000.0)
					.lance(steveJobs, 12000.0)
					.constroi();
     
        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.getLances().get(9).getValor(), 0.00001);
    
	}
	
	@Test
	public void testeDobraLanceUsuarioCorreto() {
		leilao = leilaoBuilder
					.lance(steveJobs, 2000.0)
					.lance(billGates, 4000.0)
					.dobraLanceDo(steveJobs)
					.constroi();

        assertEquals(3, leilao.getLances().size());
        assertEquals(4000.0, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
	public void testeDobraLanceUsuarioSemNenhumLance() {
		leilao = leilaoBuilder
					.lance(steveJobs, 2000.0)
					.dobraLanceDo(steveJobs)
					.constroi();
		
        assertEquals(1, leilao.getLances().size());
        
	}
	
	@Test
	public void naoDeveDobrarOLanceDeUmUsuarioSeJaTiverFeitoCincoLances() {

		leilao = leilaoBuilder
				.lance(steveJobs, 2000.0)
				.lance(billGates, 3000.0)
				.lance(steveJobs, 4000.0)
				.lance(billGates, 5000.0)
				.lance(steveJobs, 6000.0)
				.lance(billGates, 7000.0)
				.lance(steveJobs, 8000.0)
				.lance(billGates, 9000.0)
				.lance(steveJobs, 10000.0)
				.lance(billGates, 11000.0)
				.dobraLanceDo(steveJobs)
				.constroi();

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.getLances().get(9).getValor(), 0.00001);
    
	}
	
	@Test
	public void naoDeveDobrarLanceDoUsuarioSeTiverDoisLancesSeguidos() {
		leilao = leilaoBuilder
					.lance(steveJobs, 2000.0)
					.dobraLanceDo(steveJobs)
					.constroi();

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
    
	}
	
}

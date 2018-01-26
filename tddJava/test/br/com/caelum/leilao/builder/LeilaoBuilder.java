package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominios.Lance;
import br.com.caelum.leilao.dominios.Leilao;
import br.com.caelum.leilao.dominios.Usuario;

public class LeilaoBuilder {

	private Leilao leilao;

	public LeilaoBuilder(Leilao leilao) {
		this.leilao = leilao;
	}

	public LeilaoBuilder lance(Usuario steveJobs, Double valor) {
		leilao.propoe(new Lance(steveJobs, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}

	public LeilaoBuilder dobraLanceDo(Usuario usuario) {
        leilao.dobraLanceUsuario(usuario);
		return this;
	}
	
	

}

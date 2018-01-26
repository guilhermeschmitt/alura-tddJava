package br.com.caelum.leilao.dominios;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private Object ultimoLance;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);			
		}
	}

	private boolean podeDarLance(Usuario usuario) {
		return !verificaLancesSeguidos(usuario) && qtdLancesDo(usuario) < 5;
	}

	private boolean verificaLancesSeguidos(Usuario usuario) {
		return ultimoLanceDado().getUsuario().equals(usuario);
	}

	private int qtdLancesDo(Usuario usuario) {
		int total = 0;
		for (Lance lance : lances) {
			if(lance.getUsuario().equals(usuario)) {
				total++;
			}
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void dobraLanceUsuario(Usuario usuario) {
		ultimoLance = null;
		ultimoLance = ultimoLanceDo(usuario);
		if(ultimoLance != null) {
			propoe(new Lance(usuario, ((Lance) ultimoLance).getValor()*2));			
		}
		
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		for (Lance lance : lances) {
			if(lance.getUsuario().equals(usuario)) {
				ultimoLance = lance;
			}
		}
		return (Lance) ultimoLance;
	}

	
	
}

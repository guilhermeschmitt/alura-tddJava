package br.com.caelum.leilao.dominios;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Lance [usuario=" + usuario + ", valor=" + valor + "]";
	}
	
	
	
	
	
}

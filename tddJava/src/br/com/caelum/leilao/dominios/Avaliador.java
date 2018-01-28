package br.com.caelum.leilao.dominios;

import java.util.List;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double lanceMedio;
	private List<Lance> tresMaiores;

	public Avaliador() {

	}

	public void avalia(Leilao l) {
		List<Lance> lances = l.getLances();
		
		if(lances.size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão sem lances");
		}
		
		/*
		 * lances.forEach(lance -> { if(lance.getValor() > maiorDeTodos) maiorDeTodos =
		 * lance.getValor(); else if(lance.getValor() > menorDeTodos) menorDeTodos =
		 * lance.getValor(); });
		 */

		lances.stream().mapToDouble(x -> x.getValor()).max().ifPresent(max -> maiorDeTodos = max);
		lances.stream().mapToDouble(x -> x.getValor()).min().ifPresent(min -> menorDeTodos = min);
		
		pegaOsMaiores(lances);
	}

	private void pegaOsMaiores(List<Lance> lances) {
		System.out.println(lances);
         lances.sort((s1, s2) -> Double.compare(s2.getValor(), s1.getValor()));
         tresMaiores = lances.subList(0, lances.size() > 3 ? 3 : lances.size());
         
    
	}

	public void calculaLanceMedio(Leilao l) {
		List<Lance> lances = l.getLances();
		lances.stream().mapToDouble(x -> x.getValor()).average().ifPresent(avg -> lanceMedio = avg);
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public double getLanceMedio() {
		return lanceMedio;
	}
	
	public List<Lance> getTresMaiores() {
		return tresMaiores;
	}

}

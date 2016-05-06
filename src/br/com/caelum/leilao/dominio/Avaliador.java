package br.com.caelum.leilao.dominio;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double valorMedio = 0;

	public void avalia(Leilao leilao) {

		for(Lance record : leilao.getLances()) {
			if(record.getValor() > maiorDeTodos) {
				maiorDeTodos = record.getValor();
			}
			if(record.getValor() < menorDeTodos) {
				menorDeTodos = record.getValor();
			}
			valorMedio += record.getValor();
		}
		valorMedio = valorMedio / leilao.getLances().size();
		
	}

	public double getMaiorDeTodos() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

	public double getValorMedio() {
		return valorMedio;
	}
	
}

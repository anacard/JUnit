package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class AvaliadorTeste {

	@Test
	public void deveEntederMaioreMenoValor() {

		Usuario ana = new Usuario("Ana");
		Usuario paula = new Usuario("Paula");
		Leilao leilao = new Leilao("Teste");
		leilao.propoe(new Lance(ana,250.0));
		leilao.propoe(new Lance(paula,300.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 300;
		double menorEsperado = 250;

		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	

	@Test
	public void deveEntenderValorMedio() {

		Usuario ana = new Usuario("Ana");
		Usuario paula = new Usuario("Paula");
		Leilao leilao = new Leilao("Teste");
		leilao.propoe(new Lance(ana,250.0));
		leilao.propoe(new Lance(paula,300.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorEsperado = 300;
		double menorEsperado = 250;
		double mediaEsperada = (maiorEsperado + menorEsperado)/2;

		
		Assert.assertEquals(mediaEsperada, leiloeiro.getValorMedio(), 0.0001);
	}
	
	
	@Test
	public void testaUmLance() {
		double valor = 250.0;
		Usuario ana = new Usuario("Ana");
		Leilao leilao = new Leilao("Teste");
		leilao.propoe(new Lance(ana, valor));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		assertEquals(valor, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(valor, leiloeiro.getMenorDeTodos(), 0.0001);
		
	}
	
	@Test
	public void testaLancesAleatorios() {
		Usuario ana = new Usuario("Ana");
		Usuario luna = new Usuario("Luna");
		Usuario ricardo = new Usuario("Ricardo");
		Usuario jose = new Usuario("José");
		
		Leilao leilao = new Leilao("Teste");
		leilao.propoe(new Lance(ana, 500.0));
		leilao.propoe(new Lance(luna, 100.0));
		leilao.propoe(new Lance(ricardo, 90.0));
		leilao.propoe(new Lance(jose, 700.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		assertEquals(700.00, leiloeiro.getMaiorDeTodos(), 0.0001);
		assertEquals(90.0, leiloeiro.getMenorDeTodos(), 0.0001);
		
	}
}

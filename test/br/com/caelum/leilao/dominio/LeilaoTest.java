package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
		Usuario joao = new Usuario("Joao");
		Leilao leilao = new Leilao("MacBook");
		leilao.propoe(new Lance(joao, 1000));
		leilao.propoe(new Lance(joao, 2000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.0001);

	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario(){
		Usuario joao = new Usuario("Joao");
		Usuario pedro = new Usuario("Pedro");

		Leilao leilao = new Leilao("MacBook");
		leilao.propoe(new Lance(joao, 1000));
		leilao.propoe(new Lance(pedro, 2000));
		leilao.propoe(new Lance(joao, 3000));
		leilao.propoe(new Lance(pedro, 4000));
		leilao.propoe(new Lance(joao, 5000));
		leilao.propoe(new Lance(pedro, 6000));
		leilao.propoe(new Lance(joao, 7000));
		leilao.propoe(new Lance(pedro, 8000));
		leilao.propoe(new Lance(joao, 9000));
		leilao.propoe(new Lance(pedro, 10000));
		leilao.propoe(new Lance(joao, 11000));


		assertEquals(10, leilao.getLances().size());
		assertEquals(1000, leilao.getLances().get(0).getValor(), 0.0001);
		assertEquals(2000, leilao.getLances().get(1).getValor(), 0.0001);
		assertEquals(3000, leilao.getLances().get(2).getValor(), 0.0001);
		assertEquals(4000, leilao.getLances().get(3).getValor(), 0.0001);
		assertEquals(5000, leilao.getLances().get(4).getValor(), 0.0001);
		assertEquals(6000, leilao.getLances().get(5).getValor(), 0.0001);
		assertEquals(7000, leilao.getLances().get(6).getValor(), 0.0001);
		assertEquals(8000, leilao.getLances().get(7).getValor(), 0.0001);
		assertEquals(9000, leilao.getLances().get(8).getValor(), 0.0001);
		assertEquals(10000, leilao.getLances().get(9).getValor(), 0.0001);

		assertEquals("Joao", leilao.getLances().get(0).getUsuario().getNome());
		assertEquals("Pedro", leilao.getLances().get(1).getUsuario().getNome());
		assertEquals("Joao", leilao.getLances().get(2).getUsuario().getNome());
		assertEquals("Pedro", leilao.getLances().get(3).getUsuario().getNome());
		assertEquals("Joao", leilao.getLances().get(4).getUsuario().getNome());
		assertEquals("Pedro", leilao.getLances().get(5).getUsuario().getNome());
		assertEquals("Joao", leilao.getLances().get(6).getUsuario().getNome());
		assertEquals("Pedro", leilao.getLances().get(7).getUsuario().getNome());
		assertEquals("Joao", leilao.getLances().get(8).getUsuario().getNome());
		assertEquals("Pedro", leilao.getLances().get(9).getUsuario().getNome());

	}


}

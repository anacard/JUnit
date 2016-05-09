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

}

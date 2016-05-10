package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		int count = 0;
		for (Lance rec : lances) {
			if(rec.getUsuario().equals(lance.getUsuario()))
				count++;
		}
		if(lances.size() == 0 || !repeatesUsers(lance) && count < 5)
			lances.add(lance);
		


	}
	
	private boolean  repeatesUsers(Lance lance){
		if(lances.get(lances.size()-1).getUsuario().getNome().equals(lance.getUsuario().getNome()))
				return true;
		return false;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}



}

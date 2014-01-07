package br.com.tdv.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tdv.model.Contato;

public class ContatoDao {
	
	private static java.util.List<Contato> contatos = new ArrayList<Contato>();
	
	public void save(Contato contato) {
		contato.setId(contatos.size()+1);
		contatos.add(contato);
	}
	
	public List<Contato> getAllList() {
		return contatos;
	}
	
	public Contato getContato(int id) {
		for (Contato contato : contatos) {
			if(contato.getId() == id) {
				return contato;
			}
		}
		return null;
	}
	
	public boolean delete(Contato contato) {
		for (Contato c : contatos) {
			if(contato == c) {
				return contatos.remove(c);
			}
		}		
		return false;
	}

}

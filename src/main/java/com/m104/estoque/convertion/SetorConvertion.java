package com.m104.estoque.convertion;


import java.beans.PropertyEditorSupport;

import com.m104.estoque.modelo.entidades.Setor;
import com.m104.estoque.modelo.repositorios.SetorDAO;

public class SetorConvertion extends PropertyEditorSupport{

	private final SetorDAO sdao;
	
	public SetorConvertion(SetorDAO sdao){
		this.sdao = sdao;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Setor setor = sdao.buscarPorId(Integer.parseInt(text));
        setValue(setor);
	}
	
	
}

package com.diegotomfurtado.avenuecode.steps.createtasks;

public class LotCaractersExpection extends Exception {

	private static final long serialVersionUID = 7367748940241685664L;

	@Override
	public String getMessage(){
		return "Limite de caracters estrapolado.";
	}
}

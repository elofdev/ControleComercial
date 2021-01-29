package com.eofdev.repcomercial.domain.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Criar um construtor
	public NegocioException(String message) {

		super(message);
	
	}
}
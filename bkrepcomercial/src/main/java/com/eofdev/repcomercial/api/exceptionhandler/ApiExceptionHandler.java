package com.eofdev.repcomercial.api.exceptionhandler;


import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eofdev.repcomercial.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	// 4) Tradução das mensagens
	// Injetar uma instância do tipo MessageSource do SpringFrameWork
	@Autowired
	private MessageSource messageSource;

	// Cria metodo para tratamento da exception de negócio
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		
		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setDatahora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// 2) Cria uma várial chamada campos
		var campos = new ArrayList<Problema.Campo>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String campo = ((FieldError) error).getField(); // fazer um cast paa fielerror
			// 5) carrega as mensagens traduzidas
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

			campos.add(new Problema.Campo(campo, mensagem));
		}

		// 1) instancia ou cria um objeto problema
		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo("Um ou mais campos inváldos." + "Preencha corretamente e tente novamente.");
		problema.setDatahora(OffsetDateTime.now());
		problema.setCampos(campos);

		// 3) resultado
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}

}

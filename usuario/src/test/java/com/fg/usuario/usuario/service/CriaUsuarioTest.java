package com.fg.usuario.usuario.service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import com.fg.usuario.usuario.repository.IUsuarioRepository;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class CriaUsuarioTest {
	
	private CriaUsuario criaUsuario;
	private Validator validator;
	private IUsuarioRepository usuarioRepository;
	private ApplicationEventPublisher eventPublisher;

	@Test
	@BeforeAll
	public void inicioGeral() {
		ValidatorFactory validatorFactor = Validation.buildDefaultValidatorFactory();
		this.validator = validatorFactor.getValidator();
	}
	
	@BeforeEach
	public void iniciarCadaTeste() {		
		this.usuarioRepository = Mockito.mock(IUsuarioRepository.class);
		this.eventPublisher = Mockito.mock(ApplicationEventPublisher.class);
		
		criaUsuario = new CriaUsuario(validator, usuarioRepository, eventPublisher);	
	}

}

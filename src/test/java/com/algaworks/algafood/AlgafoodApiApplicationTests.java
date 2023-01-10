package com.algaworks.algafood;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIntegrationTests {

  @Autowired
  private CadastroCozinhaService cadastroCozinhaService;

  @Test
  void testarCadastroCozinhaComSucesso() {
    Cozinha novaCozinha = new Cozinha();
    novaCozinha.setNome("Chinesa");

    novaCozinha = cadastroCozinhaService.salvar(novaCozinha);

    assertThat(novaCozinha).isNotNull();
    assertThat(novaCozinha.getId()).isNotNull();
  }

  @Test
  void testarCadastroCozinhaSemNome() {
    Cozinha novaCozinha = new Cozinha();
    novaCozinha.setNome(null);

    ConstraintViolationException erroEsperado = assertThrows(ConstraintViolationException.class, () -> {
      cadastroCozinhaService.salvar(novaCozinha);
    });

    assertThat(erroEsperado).isNotNull();
  }

  @Test
  void deveFalhar_QuandoExcluirCozinhaEmUso() {
    EntidadeEmUsoException erroEsperado = assertThrows(EntidadeEmUsoException.class, () -> {
      cadastroCozinhaService.excluir(1L);
    });

    assertThat(erroEsperado).isNotNull();
  }

  @Test
  void deveFalhar_QuandoExcluirCozinhaInexistente() {
    CozinhaNaoEncontradaException erroEsperado = assertThrows(CozinhaNaoEncontradaException.class, () -> {
      cadastroCozinhaService.excluir(100L);
    });

    assertThat(erroEsperado).isNotNull();
  }
}

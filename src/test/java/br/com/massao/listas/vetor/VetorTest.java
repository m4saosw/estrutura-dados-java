package br.com.massao.listas.vetor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class VetorTest {
    private Vetor<String> vetorString;

    @BeforeEach
    void setUp() {
        vetorString = new VetorString();

    }

    @Test
    void givenVetorWhenAdicionaThenRetornaUltimoElemento() {
        vetorString.adiciona("elemento1");
        vetorString.adiciona("elemento2");
        Assertions.assertEquals("elemento2", vetorString.pega(1));
    }


    @Test
    void givenVetorWhenAdicionaThenContaElementosEquals2() {
        vetorString.adiciona("elemento1");
        vetorString.adiciona("elemento2");
        Assertions.assertTrue(vetorString.tamanho() == 2);
    }
}
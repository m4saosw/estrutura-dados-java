package br.com.massao.listas.vetor;

import java.util.Arrays;

public class VetorString implements Vetor<String>{
    private String[] elements = new String[50];
    private int count = 0;


    public void adiciona(String elemento) {
        this.elements[this.count] = elemento;
        count++;
    }

    public void adiciona(int posicao, String elemento) {

    }

    public String pega(int posicao) {
        if (! posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posição invalida");
        }

        return this.elements[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < count;
    }

    public void remove(int posicao) {
        if (! posicaoOcupada(posicao))
            throw new IllegalArgumentException("posição invalida");



        count--;
    }

    public boolean contem(String elemento) {
        for (int i = 0; i < this.elements.length; i++) {
            if (elemento.equals(this.elements[i])) return true;
        }
        return false;
    }

    public int tamanho() {
        return this.count;
    }

    @Override
    public String toString() {
        return "VetorString{" +
                "strings=" + Arrays.toString(this.elements) +
                '}';
    }
}

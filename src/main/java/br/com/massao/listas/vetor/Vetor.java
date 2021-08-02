package br.com.massao.listas.vetor;

public interface Vetor<T> {
    void adiciona(T elemento);

    void adiciona(int posicao, T elemento);

    T pega(int posicao);

    void remove(int posicao);

    boolean contem(T elemento);

    int tamanho();
}

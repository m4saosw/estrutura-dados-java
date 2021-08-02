package br.com.massao.listas.listaligada;

public interface ListaLigada {
    /**
     * Adiciona no fim da lista
     * @param elemento
     */
    void adiciona(Object elemento);

    void adiciona(int posicao, Object elemento);

    Object pega(int posicao);

    void remove(int posicao);

    int tamanho();

    boolean contem(Object o);

    void adicionaNoComeco(Object elemento);

    void removeDoComeco();

    void removeDoFim();
}

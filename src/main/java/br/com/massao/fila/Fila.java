package br.com.massao.fila;

import java.util.LinkedList;
import java.util.List;

/**
 * A fila é um subconjunto de lista, com operações mais restritas.
 * Dada a necessidade de remoção pelo inicio da lista, a estrutura de lista mais eficiente é a lista ligada.
 *
 * @param <T>
 */
public class Fila<T> {
    private List<T> objetos = new LinkedList<>();

    public void insere(T o) {
        this.objetos.add(o);
    }

    public T remove() {
        if (vazia()) return null;

        return this.objetos.remove(0);
    }

    public boolean vazia() {
        return this.objetos.isEmpty();
    }
}

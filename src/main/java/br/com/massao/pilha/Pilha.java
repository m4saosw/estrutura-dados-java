package br.com.massao.pilha;

import java.util.LinkedList;
import java.util.List;

/**
 * A pilha é um subconjunto de Lista, com menos operacoes. Assim como lista, armazena em modo sequencial
 * @param <T>
 */
public class Pilha<T> {
    private List<T> objetos = new LinkedList<>();

    public void insere(T t) {
        this.objetos.add(t);
    }

    public boolean vazia() {
        return this.objetos.isEmpty();
    }

    public T remove() {
        return this.objetos.remove(this.objetos.size() - 1);
    }
}

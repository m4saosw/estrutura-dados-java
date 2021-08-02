package br.com.massao.listas.listaligada;

public class ListaLigadaImpl implements ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    @Override
    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);

            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    /**
     * Adiciona no fim da lista
     *
     * @param elemento
     */
    @Override
    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) { // no começo
            adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) {  // no fim
            adiciona(elemento);
        } else { // posição intermediaria
            Celula anterior = pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();

            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);

            anterior.setProxima(nova);
            proxima.setAnterior(nova);

            this.totalDeElementos++;
        }


    }

    @Override
    public Object pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    @Override
    public void remove(int posicao) {
        if (posicao == 0) {  // começo
            removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {  // final
            removeDoFim();
        } else {
            // meio
            Celula anterior = pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            this.totalDeElementos--;
        }

    }

    @Override
    public int tamanho() {
        return this.totalDeElementos;
    }

    @Override
    public boolean contem(Object o) {
        Celula atual = this.primeira;
        while (atual != null) {
            if (atual.getElemento().equals(o))
                return true;

            atual = atual.getProxima();
        }

        return false;
    }

    @Override
    public void adicionaNoComeco(Object elemento) {
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = this.primeira;
        } else { // a nova celula deve apontar para o antigo primeiro
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;


        }
        this.totalDeElementos++;
    }

    @Override
    public void removeDoComeco() {
        if (!this.posicaoOcupada(0))
            throw new IllegalArgumentException("Posição vazia");

        this.primeira = this.primeira.getProxima();
        totalDeElementos--;

        if (this.totalDeElementos == 0)
            this.ultima = null;
    }

    @Override
    public void removeDoFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1))
            throw new IllegalArgumentException("Posição vazia");

        if (this.totalDeElementos == 1) {
            removeDoComeco();
        } else {
            Celula anterior = this.pegaCelula(this.totalDeElementos - 1);
            anterior.setProxima(null);
            this.ultima = anterior;

            this.totalDeElementos--;
        }


    }


    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        // Inicia a varredura a partir da primeira celula ate a posicao solicitada
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }
}

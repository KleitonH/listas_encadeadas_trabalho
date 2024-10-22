public class PedidosCancelados<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Posição não existe.";
    private final String LISTA_VAZIA = "Lista está vazia.";
    private static final int MENOR = -1;
    private static final int IGUAL_MAIOR = 0;

    public void adiciona(T elemento) {
        No<T> celula = new No<T>(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento) {
        if (this.tamanho == 0) {
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public T removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    private boolean posicaoNaoExiste(int posicao) {
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public int getTamanho() {
        return this.tamanho;
    }


    private No<T> buscaNo(int posicao) {

        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    public void imprimir(){
        if(inicio == null){
            System.out.println("Lista vazia.");
            return;
        }
        No<T> noAtual = inicio;

        while (noAtual != null){
            System.out.print(noAtual.getElemento() + " ");
            noAtual = noAtual.getProximo();
        }
        System.out.println();
    }

    public T exibirPrimeiro() {
        if (inicio != null) {
            return inicio.getElemento();
        } else {
            return null;
        }
    }
    public T exibirUltimo() {
        if (ultimo != null) {
            return ultimo.getElemento();
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public T[] transformaArray() {
        if (this.tamanho == 0) {
            return (T[]) new Object[0];
        }
        Object[] vetor = new Object[this.tamanho];
        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            vetor[i] = atual.getElemento();
            atual = atual.getProximo();
        }
        return (T[]) vetor;
    }

    @Override
    public String toString() {

        // [1, 2, 3, 4]

        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        // builder.append("ListaEncadeada [inicio=").append(inicio).append("]");

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        /*
         * builder.append(atual.getElemento()).append(",");
         * while (atual.getProximo() != null) {
         * atual = atual.getProximo();
         * builder.append(atual.getElemento()).append(",");
         * }
         */

        return builder.toString();
    }

}
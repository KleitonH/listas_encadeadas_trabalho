public class Biblioteca {
    private No inicio;
    private No fim;
    private int tamanho;

    public Biblioteca() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    // Adicionar livro no início
    public void adicionarInicio(int id, String titulo, String autor) {
        No novoNo = new No(id, titulo, autor);
        if (tamanho == 0) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        tamanho++;
    }

    // Adicionar livro no fim
    public void adicionarFim(int id, String titulo, String autor) {
        No novoNo = new No(id, titulo, autor);
        if (tamanho == 0) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        tamanho++;
    }

    // Remover livro do início
    public No removerInicio() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return null;
        }

        No removido = inicio;
        if (tamanho == 1) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        tamanho--;
        System.out.println("Livro removido: " + removido);
        return removido;
    }

    // Remover livro do fim
    public No removerFim() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return null;
        }

        No removido = fim;
        if (tamanho == 1) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }
        tamanho--;
        System.out.println("Livro removido: " + removido);
        return removido;
    }

    // Buscar livro por ID
    public No buscarPorId(int id) {
        No atual = inicio;
        while (atual != null) {
            if (atual.getId() == id) {
                System.out.println("Livro encontrado: " + atual);
                return atual;
            }
            atual = atual.getProximo();
        }
        System.out.println("Livro com ID " + id + " não encontrado.");
        return null;
    }

    // Imprimir livros na ordem original
    public void imprimirOrdemOriginal() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = inicio;
        while (atual != null) {
            System.out.print(atual + "; ");
            atual = atual.getProximo();
        }
    }

    // Imprimir livros na ordem reversa
    public void imprimirOrdemReversa() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = fim;
        while (atual != null) {
            System.out.print(atual + "; ");
            atual = atual.getAnterior();
        }
    }
}

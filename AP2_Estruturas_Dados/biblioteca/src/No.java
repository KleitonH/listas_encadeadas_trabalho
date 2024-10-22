public class No {

    private int id;
    private String titulo;
    private String autor;
    private No anterior;
    private No proximo;

    public No(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anterior = null;
        this.proximo = null;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Livro [ID=" + id + ", Titulo=" + titulo + ", Autor=" + autor + "]";
    }
}

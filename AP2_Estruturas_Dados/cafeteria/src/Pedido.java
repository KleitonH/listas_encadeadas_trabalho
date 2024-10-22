public class Pedido {
    private int id;
    private String descricao;

    public Pedido(int id, String descricao) {
        this.descricao = descricao;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Pedido [ID=%d, Descrição=%s]", id, descricao);
    }
}
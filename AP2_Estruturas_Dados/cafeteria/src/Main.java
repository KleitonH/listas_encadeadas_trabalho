import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PedidosPendentes<Pedido> pedidosPendentes = new PedidosPendentes<>();
        PedidosCancelados<Pedido> pedidosCancelados = new PedidosCancelados<>();
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Listar Pedidos Pendentes");
            System.out.println("6. Listar Pedidos Cancelados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do pedido: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer após ler o inteiro
                    System.out.print("Digite a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    pedidosPendentes.adiciona(new Pedido(id, descricao));
                    System.out.println("Pedido adicionado com sucesso.");
                    break;

                case 2:
                    System.out.println(String.format("Finalizando o pedido: %s", pedidosPendentes.exibirPrimeiro()));
                    System.out.println("Pedido atendido com sucesso.");
                    pedidosPendentes.removeInicio();
                    break;
                case 3:
                    Pedido pedidoCancelado = pedidosPendentes.exibirPrimeiro();
                    pedidosPendentes.removeInicio();
                    pedidosCancelados.adicionaInicio(pedidoCancelado);
                    System.out.println(String.format("O pedido %s foi cancelado", pedidoCancelado));
                    break;
                case 4:
                    pedidosPendentes.adicionaInicio(pedidosCancelados.exibirPrimeiro());
                    pedidosCancelados.removeInicio();
                    System.out.println(String.format("O pedido %s foi restaurado", pedidosPendentes.exibirPrimeiro()));
                    break;
                case 5:
                    pedidosPendentes.imprimir();
                    break;
                case 6:
                    pedidosCancelados.imprimir();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}


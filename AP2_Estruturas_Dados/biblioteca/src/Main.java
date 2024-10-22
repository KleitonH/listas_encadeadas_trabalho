import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n---- Menu Biblioteca ----");
            System.out.println("1. Adicionar Livro no Início");
            System.out.println("2. Adicionar Livro no Fim");
            System.out.println("3. Remover Livro do Início");
            System.out.println("4. Remover Livro do Fim");
            System.out.println("5. Buscar Livro por ID");
            System.out.println("6. Imprimir Livros");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do Livro: ");
                    int idInicio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título do Livro: ");
                    String tituloInicio = scanner.nextLine();
                    System.out.print("Autor do Livro: ");
                    String autorInicio = scanner.nextLine();
                    biblioteca.adicionarInicio(idInicio, tituloInicio, autorInicio);
                    break;
                case 2:
                    System.out.print("ID do Livro: ");
                    int idFim = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título do Livro: ");
                    String tituloFim = scanner.nextLine();
                    System.out.print("Autor do Livro: ");
                    String autorFim = scanner.nextLine();
                    biblioteca.adicionarFim(idFim, tituloFim, autorFim);
                    break;
                case 3:
                    biblioteca.removerInicio();
                    break;
                case 4:
                    biblioteca.removerFim();
                    break;
                case 5:
                    System.out.print("ID do Livro: ");
                    int idBusca = scanner.nextInt();
                    biblioteca.buscarPorId(idBusca);
                    break;
                case 6:
                    System.out.println("\nEscolha a ordem de impressão:");
                    System.out.println("1. Ordem Original");
                    System.out.println("2. Ordem Reversa");
                    int ordem = scanner.nextInt();
                    if (ordem == 1) {
                        biblioteca.imprimirOrdemOriginal();
                    } else if (ordem == 2) {
                        biblioteca.imprimirOrdemReversa();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}

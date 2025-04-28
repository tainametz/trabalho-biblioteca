import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    adicionarLivro(biblioteca, scanner);
                    break;
                case 2:
                    pesquisarPorTitulo(biblioteca, scanner);
                    break;
                case 3:
                    listarTodos(biblioteca);
                    break;
                case 4:
                    removerPorTitulo(biblioteca, scanner);
                    break;
                case 5:
                    pesquisarPorAutor(biblioteca, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("==== Biblioteca ====");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Pesquisar livro por título");
        System.out.println("3 - Listar todos os livros");
        System.out.println("4 - Remover livro por título");
        System.out.println("5 - Pesquisar livro por autor");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Número de páginas: ");
        int paginas = Integer.parseInt(scanner.nextLine());

        System.out.print("Formato (1 - Físico, 2 - Digital): ");
        int formato = Integer.parseInt(scanner.nextLine());

        Livro livro;
        if (formato == 1) {
            livro = new LivroFisico(titulo, autor, ano, paginas);
        } else {
            livro = new LivroDigital(titulo, autor, ano, paginas);
        }

        if (biblioteca.adicionarLivro(livro)) {
            System.out.println("Livro adicionado com sucesso!");
        }
    }

    private static void pesquisarPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título para buscar: ");
        String titulo = scanner.nextLine();
        List<Livro> encontrados = biblioteca.buscarLivrosPorTitulo(titulo);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : encontrados) {
                exibirLivroDetalhado(livro);
            }
        }
    }

    private static void listarTodos(Biblioteca biblioteca) {
        List<Livro> livros = biblioteca.listarLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                exibirLivroDetalhado(livro);
            }
        }
    }

    private static void removerPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título para remover: ");
        String titulo = scanner.nextLine();
        int removidos = biblioteca.removerLivroPorTitulo(titulo);
        System.out.println(removidos + " livro(s) removido(s).");
    }

    private static void pesquisarPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o autor para buscar: ");
        String autor = scanner.nextLine();
        List<Livro> encontrados = biblioteca.buscarLivrosPorAutor(autor);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (Livro livro : encontrados) {
                exibirLivroDetalhado(livro);
            }
        }
    }

    private static void exibirLivroDetalhado(Livro livro) {
        System.out.println(livro);
        System.out.println("Formato: " + livro.getFormato());
        System.out.println("Tempo de publicação: " + livro.calcularTempoPublicacao() + " anos");
        System.out.println("------------------------------");
    }
}
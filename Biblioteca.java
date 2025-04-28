import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    public static final int ANO_PUBLICACAO_MINIMO = 1400;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public boolean adicionarLivro(Livro livro) {
        if (livro.getTitulo().isBlank() || livro.getAutor().isBlank()) {
            System.out.println("Título e autor não podem estar em branco.");
            return false;
        }
        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO) {
            System.out.println("Ano de publicação inválido. Deve ser a partir de " + ANO_PUBLICACAO_MINIMO + ".");
            return false;
        }
        if (livro.getNumeroPaginas() <= 0) {
            System.out.println("Número de páginas deve ser maior que zero.");
            return false;
        }
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                System.out.println("Já existe um livro com esse título.");
                return false;
            }
        }
        livros.add(livro);
        return true;
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public List<Livro> buscarLivrosPorTitulo(String tituloBusca) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(tituloBusca.toLowerCase())) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public List<Livro> buscarLivrosPorAutor(String autorBusca) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().toLowerCase().contains(autorBusca.toLowerCase())) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public int removerLivroPorTitulo(String tituloBusca) {
        int quantidadeRemovida = 0;
        Iterator<Livro> iterator = livros.iterator();
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getTitulo().toLowerCase().contains(tituloBusca.toLowerCase())) {
                iterator.remove();
                quantidadeRemovida++;
            }
        }
        return quantidadeRemovida;
    }
}
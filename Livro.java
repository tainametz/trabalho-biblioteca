import java.time.Year;

public abstract class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public int calcularTempoPublicacao() {
        int anoAtual = Year.now().getValue();
        return anoAtual - anoPublicacao;
    }

    public abstract String getFormato();

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAno: " + anoPublicacao + "\nPáginas: " + numeroPaginas;
    }
}
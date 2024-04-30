package br.com.alura.oneOrecle.modelo;

public class Serie extends Titulo{
    private int temporada,episodeoPorTemporada,minutosPorEpisodio;
    private boolean ativo;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }



    @Override
    public int getDuracaoEmMinutos(){
        return temporada*episodeoPorTemporada*minutosPorEpisodio;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodeoPorTemporada() {
        return episodeoPorTemporada;
    }

    public void setEpisodeoPorTemporada(int episodeoPorTemporada) {
        this.episodeoPorTemporada = episodeoPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String toString() {
        return "Seriado: "+ this.getNome() + "("+ this.getAnoDeLancamento() + ")";
    }
}

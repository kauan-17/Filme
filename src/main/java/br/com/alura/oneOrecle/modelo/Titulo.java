package br.com.alura.oneOrecle.modelo;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private int totalAvalicao;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somoDasAvalicoes;

    public Titulo(TituloOmdb meutituloOmbd) {
        if(meutituloOmbd.year().length()>4){
            throw new ErroDeConversaoDeAnoException("Não conseguir coverter o ano?");
        }

        this.nome = meutituloOmbd.original_title();
        this.anoDeLancamento = Integer.valueOf(meutituloOmbd.year());
        this.duracaoEmMinutos = Integer.valueOf(meutituloOmbd.runtime().substring(0,2));
    }


    public void exibirFichaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lancamento: " + anoDeLancamento);
        System.out.println("Duração do filme: "+ duracaoEmMinutos);
        System.out.println("normal: "+incluidoNoPlano);
    }
    public void avalia( double nota){
        somoDasAvalicoes += nota;
        totalAvalicao++;

    }

    public Titulo(String nome,int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


    public double pegaMedia(){
        return somoDasAvalicoes / totalAvalicao;
    }

    @Override
    public int compareTo(@NotNull Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getTotalAvalicao() {
        return totalAvalicao;
    }

    public void setTotalAvalicao(int totalAvalicao) {
        this.totalAvalicao = totalAvalicao;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomoDasAvalicoes() {
        return somoDasAvalicoes;
    }

    public void setSomoDasAvalicoes(double somoDasAvalicoes) {
        this.somoDasAvalicoes = somoDasAvalicoes;
    }

    @Override
    public String toString() {
        return "nome= " + nome  +
                ", anoDeLancamento= " + anoDeLancamento + ","
                + "duraçaõ= "+ duracaoEmMinutos;
    }
}

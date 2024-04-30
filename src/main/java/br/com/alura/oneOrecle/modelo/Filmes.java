package br.com.alura.oneOrecle.modelo;

import br.com.alura.oneOrecle.calculos.Classificar;

public class Filmes extends Titulo implements Classificar {
    private String diretor;

    public Filmes(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }


    @Override
    public int getClassificacao() {
            return (int) pegaMedia() / 2;
        }

    @Override
    public String toString() {
        return "Filmes: "+ this.getNome() + "("+ this.getAnoDeLancamento() + ")";
    }
}




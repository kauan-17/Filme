package br.com.alura.oneOrecle.calculos;

import org.jetbrains.annotations.NotNull;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(@NotNull Classificar classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
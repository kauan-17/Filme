package br.com.alura.oneOrecle.calculos;

import br.com.alura.oneOrecle.modelo.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public void inclui(Titulo t) {
        tempoTotal +=t.getDuracaoEmMinutos();

    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}

package br.com.alura.oneOrecle.principal;

import br.com.alura.oneOrecle.modelo.Filmes;
import br.com.alura.oneOrecle.modelo.Serie;
import br.com.alura.oneOrecle.modelo.Titulo;

import java.util.*;

public class Lista {
    public static void main(String[] args) {
        Filmes meuFilme = new Filmes("o podereso chejão",1970);
        meuFilme.avalia(90);
        Filmes outroFilme = new Filmes("Avatar",2023);
        outroFilme.avalia(60);
        var filmeDo =new Filmes("Dogville",2003);
        filmeDo.avalia(60);
        Serie lost = new Serie("Lost",2000);

        ArrayList<Titulo>lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeDo);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if(item instanceof Filmes filmes && filmes.getClassificacao()>2){
            System.out.println("clasificação: "+ filmes.getClassificacao());
            }
        }
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paula fernade");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulo ordenado");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println("ordenado por ano");
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);

    }
}

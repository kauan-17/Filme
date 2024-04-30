package br.com.alura.oneOrecle.principal;

import br.com.alura.oneOrecle.calculos.FiltroRecomendacao;
import br.com.alura.oneOrecle.modelo.Episodio;
import br.com.alura.oneOrecle.modelo.Filmes;
import br.com.alura.oneOrecle.modelo.Serie;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        FiltroRecomendacao recomendacao = new FiltroRecomendacao();
        Episodio episodio = new Episodio();

        System.out.println("\n----------------Filme--------------------------\n");
        ArrayList<Filmes> listaDeFilme = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o nome do filme (ou 'sair' para parar): ");
            String nome = sc.nextLine();
            if (nome.equals("sair")) {
                break;
            }
            System.out.println("Qual foi o ano de lançamento do filme: ");
            int anoDeLancamento = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite a duração do filme: ");
            int duracaoEmMinutos = sc.nextInt();
            sc.nextLine();
            int[] avalia = new int[3];
            Filmes filme = new Filmes(nome, anoDeLancamento);
            for (int i = 0; i < 3; i++) {
                System.out.println("Qual é a avaliação " + (i + 1) + " do filme:");
                int nota = sc.nextInt();
                sc.nextLine();
                filme.avalia(nota);
            }
            listaDeFilme.add(filme);
        }

        System.out.println("\n-----------------------------------------------\n");

         System.out.println("\n---------------serie--------------------------\n");
        ArrayList<Serie> listaDeSerie = new ArrayList<>();
        Scanner sca = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o nome do Seriado (ou 'sair' para parar): ");
            String nome = sca.nextLine();
            if (nome.equals("sair")) {
                break;
            }
            System.out.println("Qual foi o ano de lançamento do Seriado: ");
            int anoDeLancamento = sca.nextInt();
            sca.nextLine();
            System.out.println("Digite a duração do Seriado: ");
            int duracaoEmMinutos = sca.nextInt();
            sca.nextLine();
            int[] avalia = new int[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("Qual é a avaliação " + (i + 1) + " do Seriado:");
                avalia[i] = sca.nextInt();
                sca.nextLine();
            }
            Serie series = new Serie(nome, anoDeLancamento);
            listaDeSerie.add(series);
        }

        System.out.println("\nInformação Digitadas:");
        for (Filmes filmes : listaDeFilme) {
            System.out.println("Nome: " + filmes.getNome() + ", duração do filme: " + filmes.getAnoDeLancamento() );
            recomendacao.filtra(listaDeFilme.get(0));
        }

        for (Serie serie : listaDeSerie) {
            System.out.println("Nome: " + serie.getNome() + ", duração do serie: " + serie.getAnoDeLancamento() );
            episodio.setNumero(1);
            if (!listaDeSerie.isEmpty()) {
                episodio.setSerie(listaDeSerie.get(0));
            } else {
                System.out.println("Nenhuma série adicionada.");
            }
            episodio.setTotalVisualizacoes(300);
            System.out.println("O seriado e :"+listaDeSerie.get(0).getNome());
            recomendacao.filtra(episodio);
        }

    }
}

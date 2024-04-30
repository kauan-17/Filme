package br.com.alura.oneOrecle.principal;

import br.com.alura.oneOrecle.modelo.ErroDeConversaoDeAnoException;
import br.com.alura.oneOrecle.modelo.Titulo;
import br.com.alura.oneOrecle.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Busca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("digitar um filme para busca:");
            busca = sc.nextLine();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://api.themoviedb.org/3/search/movie?api_key=7280602776de3d5326ce544b68c7e140&query="+busca.replace(" ","");
            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        //.uri(URI.create("http://www.omdbapi.com/?i=tt3896198&apikey=96acb81"))
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(response.body());


                //Titulo meutitulo = gson.fromJson(response.body(), Titulo.class);
                TituloOmdb meutituloOmbd = gson.fromJson(response.body(), TituloOmdb.class);
                System.out.println(meutituloOmbd);


                Titulo meuTitulo = new Titulo(meutituloOmbd);
                System.out.println("Titulo convertigo");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NullPointerException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalAccessError e) {
                System.out.println("algun erro de argumento na busca, verifica o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter escrever = new FileWriter("titulos.json");
        escrever.write(gson.toJson(titulos));
        escrever.close();
        System.out.println("o programa finalizaou corretamente!");
    }
}

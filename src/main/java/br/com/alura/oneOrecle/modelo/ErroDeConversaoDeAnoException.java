package br.com.alura.oneOrecle.modelo;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private  String mensagem;
    public ErroDeConversaoDeAnoException(String s) {
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}

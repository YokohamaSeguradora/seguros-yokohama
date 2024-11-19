package br.com.yokohama.seguros.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    public static final String SHA256 = "SHA-256"; // Constante para algoritmo SHA-256
    public static final String MD5 = "MD5";       // Constante para algoritmo MD5

    private String informacao; // Informação a ser criptografada
    private String padrao;     // Algoritmo de hash (ex.: SHA-256 ou MD5)

    /**
     * Construtor para inicializar a classe com a informação e o padrão de criptografia.
     *
     * @param informacao Texto a ser criptografado.
     * @param padrao Algoritmo de criptografia a ser utilizado.
     */
    public Criptografia(String informacao, String padrao) {
        this.informacao = informacao;
        this.padrao = padrao;
    }

    // Getters
    public String getInformacao() {
        return informacao;
    }

    public String getPadrao() {
        return padrao;
    }

    // Setters
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    /**
     * Método para criptografar a informação usando o algoritmo especificado no atributo `padrao`.
     *
     * @return String criptografada em hexadecimal (letras maiúsculas) ou mensagem de erro em caso de falha.
     */
    public String criptografar() {
        // Validação para evitar erros
        if (informacao == null || informacao.isEmpty()) {
            return "A informação não pode ser nula ou vazia.";
        }

        if (padrao == null || padrao.isEmpty()) {
            return "O padrão de criptografia não foi definido.";
        }

        StringBuilder hexString = new StringBuilder(); // String para armazenar o hash em hexadecimal

        try {
            // Inicializa o MessageDigest com o algoritmo especificado
            MessageDigest messageDigest = MessageDigest.getInstance(padrao);

            // Gera o hash da informação em bytes
            byte[] hash = messageDigest.digest(informacao.getBytes(StandardCharsets.UTF_8));

            // Converte cada byte do hash em hexadecimal
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b); // Converte o byte para hexadecimal
                if (hex.length() == 1) {
                    hexString.append('0'); // Adiciona zero à esquerda se necessário
                }
                hexString.append(hex);
            }

        } catch (NoSuchAlgorithmException e) {
            // Tratamento de exceção se o algoritmo for inválido
            return "Erro: Algoritmo de criptografia não encontrado.";
        }

        // Retorna a string criptografada em letras maiúsculas
        return hexString.toString().toUpperCase();
    }
}
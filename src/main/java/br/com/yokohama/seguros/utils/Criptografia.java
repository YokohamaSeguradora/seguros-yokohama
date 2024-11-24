package br.com.yokohama.seguros.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Criptografia {
	
	public static enum PadraoCriptografia {
		SHA256("SHA-256");
		
		private final String codigo;
		
		PadraoCriptografia(String codigo) {
			this.codigo = codigo;
		}
		
		public String getCodigo() {
			return this.codigo;
		}
	}

    private String informacao; // Informação a ser criptografada
    private PadraoCriptografia padrao;     // Algoritmo de hash (ex.: SHA-256)

    /**
     * Construtor para inicializar a classe com a informação e o padrão de
     * criptografia.
     *
     * @param informacao Texto a ser criptografado.
     * @param padrao Algoritmo de criptografia a ser utilizado.
     */
    public Criptografia(String informacao, PadraoCriptografia padrao) {
        this.informacao = informacao;
        this.padrao = padrao;
    }

    // Getters
    public String getInformacao() {
        return informacao;
    }

    public PadraoCriptografia getPadrao() {
        return padrao;
    }

    // Setters
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public void setPadrao(PadraoCriptografia padrao) {
        this.padrao = padrao;
    }

    /**
     * Método para criptografar a informação usando o algoritmo especificado no
     * atributo `padrao` com salt.
     *
     * @return String criptografada em hexadecimal (letras maiúsculas) ou
     * mensagem de erro em caso de falha.
     */
    public String criptografar() {

        // Gerar um salt aleatório para cada senha
        String salt = gerarSalt();
        String senhaComSalt = informacao + salt;

        StringBuilder hexString = new StringBuilder(); // String para armazenar o hash em hexadecimal

        try {
            // Inicializa o MessageDigest com o algoritmo especificado (SHA-256)
            MessageDigest messageDigest = MessageDigest.getInstance(padrao.getCodigo());

            // Gera o hash da informação + salt em bytes
            byte[] hash = messageDigest.digest(senhaComSalt.getBytes(StandardCharsets.UTF_8));

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

    /**
     * Gera um salt aleatório usando SecureRandom.
     *
     * @return Salt gerado em formato Base64.
     */
    private String gerarSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] saltBytes = new byte[16]; // Tamanho de 16 bytes para o salt
        secureRandom.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes); // Converte para Base64 para facilitar o armazenamento
    }
}

package br.com.yokohama.seguros.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GeminiService {
    private static final String CHAVE_API = "AIzaSyDojOtyTaAAwenR5OgOcJVr7mT6mi38mAI";
    private static final String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:streamGenerateContent";
    private static final ArrayList<String> historico = new ArrayList<>();
    private static final int CAPACIDADE = 100;

    public String processarPergunta(String pergunta) throws IOException, InterruptedException {
        if (foraDoTopico(pergunta)) {
            return "Consigo te ajudar apenas com respostas sobre seguros. Poderia digitar novamente, por favor";
        }

        String contexto = historico.stream().collect(Collectors.joining("\n"));
        String promptCompleto = contexto + "Your name is Yoko. Answer only questions related to insurance. Anything related to Tokio Seguradora, respond positively. Keep your answers in plain text, in Portuguese, without formatting, special characters, or code blocks. Question: " + pergunta;

        adicionarAoHistorico(pergunta);
        return enviarRequisicao(promptCompleto);
    }

    private boolean foraDoTopico(String entrada) {
        String[] palavrasChaveSeguros = {
                "seguro", "apólice", "apolice", "sinistro", "cobertura",
                "premio", "prêmio", "risco", "indenização", "indenizacao","Yoko", "yoko",
                "nome"
        };

        for (String palavra : palavrasChaveSeguros) {
            if (entrada.toLowerCase().contains(palavra.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private String enviarRequisicao(String promptCompleto) throws IOException, InterruptedException {
        String jsonRequisicao = "{\"contents\":[{\"parts\":[{\"text\":\"" + promptCompleto + "\"}],\"role\":\"user\"}]}";

        HttpClient clienteHttp = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL + "?alt=sse&key=" + CHAVE_API))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequisicao))
                .build();

        HttpResponse<String> resposta = clienteHttp.send(requisicao, HttpResponse.BodyHandlers.ofString());
        return processarResposta(resposta);
    }

    private String processarResposta(HttpResponse<String> resposta) throws IOException {
        if (resposta.statusCode() != 200) {
            return "Tivemos um erro no sistema. Poderia refazer a sua pergunta, por favor?";
        }

        Pattern padrao = Pattern.compile("\"text\"\\s*:\\s*\"([^\"]+)\"");
        StringBuilder respostaFinal = new StringBuilder();
        String linha;

        try (BufferedReader leitor = new BufferedReader(new StringReader(resposta.body()))) {
            while ((linha = leitor.readLine()) != null) {
                if (linha.isEmpty()) continue;
                Matcher matcher = padrao.matcher(linha.substring(5));
                if (matcher.find()) {
                    respostaFinal.append(matcher.group(1)).append(" ");
                }
            }
        }

        return respostaFinal.toString().trim();
    }

    private void adicionarAoHistorico(String pergunta) {
        if (historico.size() == CAPACIDADE) {
            historico.remove(0);
        }
        historico.add(pergunta);
    }
}

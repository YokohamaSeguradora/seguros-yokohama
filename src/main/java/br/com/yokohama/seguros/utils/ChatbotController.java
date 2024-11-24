package br.com.yokohama.seguros.utils;

import java.io.IOException;
import java.util.Scanner;

import br.com.yokohama.seguros.services.GeminiService;

public class ChatbotController {

    private final GeminiService geminiService = new GeminiService();

    public void iniciarChat() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("[Usuário]:");
                String pergunta = scanner.nextLine();

                if (pergunta.equalsIgnoreCase("sair")) {
                    System.out.println("Yoko: Até a próxima!");
                    break;
                }

                String resposta = geminiService.processarPergunta(pergunta);
                System.out.println("Yoko: " + resposta);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao processar sua solicitação: " + e.getMessage());
        }
    }
}

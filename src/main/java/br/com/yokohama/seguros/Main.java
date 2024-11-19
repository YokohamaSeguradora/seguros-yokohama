package br.com.yokohama.seguros;

import br.com.yokohama.seguros.controller.ChatbotController;

public class Main {
    public static void main(String[] args) {
        ChatbotController chatbotController = new ChatbotController();
        chatbotController.iniciarChat();
    }
}

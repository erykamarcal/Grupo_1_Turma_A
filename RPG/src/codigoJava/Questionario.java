package codigoJava;

import java.util.Scanner;

public class Questionario {

    //Julia: Modified


        static Scanner sc = new Scanner(System.in);
        static int pontuacao = 0;

        public static void main(String[] args) throws InterruptedException {
            inicio();
        }


        // throws: é por minha pesquisa é usada para lançar explicitamente uma exceção de um méttodo ou de qualquer bloco de código como palavra chave
        // ==================== INÍCIO DO JOGO ====================
        static void inicio() throws InterruptedException {
            digitar("Caleb: Ei! Antes de prosseguirmos, gostaria de fazer um mini teste para verificar o seu entendimento?");
            digitar("Digite 'Sim' para iniciar ou 'Não' para pular e seguir com o gameplay.");
            String escolha = sc.nextLine().trim().toLowerCase(); //pode ser usado para ler uma linha inteira de texto ou para ler a entrada até encontrar um caractere ou sequência específica

            if (escolha.equals("sim")) {
                miniTeste();
            } else {
                digitar("Caleb: Tudo bem, piloto. Vamos continuar o gameplay.");
            }
        }

        // ==================== MINI TESTE ====================
        static void miniTeste() throws InterruptedException {
            questao("Decimal → Binário", "Converta o número 9 (decimal) para binário.",
                    "1001",
                    new String[]{"Divida por 2 até chegar a 0.", "Leia os restos de baixo para cima.",
                            "Pense em 2⁰, 2¹, 2²...", "O resultado começa com 1 e termina com 1."});

            questao("Binário → Decimal", "Converta o número 111 (binário) para decimal.",
                    "7",
                    new String[]{"Cada dígito corresponde a uma potência de 2.", "Some os valores das posições com 1.",
                            "1×2² + 1×2¹ + 1×2⁰", "4 + 2 + 1 = ?"});

            questao("Decimal → Octal", "Converta o número 16 (decimal) para octal.",
                    "20",
                    new String[]{"Divida o número por 8 até chegar a 0.", "Leia os restos de baixo para cima.",
                            "O primeiro resto será 0.", "O resultado tem dois dígitos."});

            questao("Octal → Decimal", "Converta o número 31 (octal) para decimal.",
                    "25",
                    new String[]{"Multiplique cada dígito pela potência de 8.", "3×8¹ + 1×8⁰", "24 + 1 = ?", "O resultado é 25."});

            questao("Conversão Combinada", "Qual é o binário e o octal do número 10 (decimal)?",
                    "1010 12",
                    new String[]{"Divida o número por 2 e depois por 8.", "Binário usa 0 e 1, octal vai até 7.",
                            "Decimal → Binário → divida por 2 até 0.", "Decimal → Octal → divida por 8 até 0."});

            resultadoFinal();
        }

        // ==================== QUESTÕES ====================
        static void questao(String titulo, String pergunta, String respostaCorreta, String[] dicas) throws InterruptedException {
            digitar("\n🧩 Questão: " + titulo);
            digitar("Caleb: " + pergunta);
            Thread.sleep(1000);

            int tentativas = 0;
            boolean acertou = false;

            while (tentativas < 3 && !acertou) {
                digitar("💬 Sua resposta (ou digite 'ajuda' para dica): ");
                String resposta = sc.nextLine().trim();

                if (resposta.equalsIgnoreCase("ajuda")) {
                    mostrarDicas(dicas);
                    continue;
                }

                if (resposta.equals(respostaCorreta)) {
                    digitar("✅ Caleb: Excelente! Você acertou!");
                    pontuacao++;
                    acertou = true;
                } else {
                    tentativas++;
                    if (tentativas == 1)
                        digitar("Caleb: Ei, tome cuidado. Isso pode te prejudicar futuramente. Vamos tentar de novo.");
                    else if (tentativas == 2)
                        digitar("Caleb: Se estiver nervoso, não tem problema. Se acalme e pense mais um pouco.");
                    else {
                        digitar("Caleb: Quer ver o ensinamento novamente antes de continuar? (Sim/Não)");
                        String escolha = sc.nextLine().trim().toLowerCase();
                        if (escolha.equals("sim")) {
                            tutorial(titulo);
                            tentativas = 0; // reinicia as tentativas
                        } else {
                            digitar("Caleb: Tudo bem, seguimos em frente.");
                        }
                    }
                }
            }

            if (!acertou) {
                digitar("❌ Caleb: A resposta correta era: " + respostaCorreta);
            }
        }

        // ==================== SISTEMA DE DICAS ====================
        static void mostrarDicas(String[] dicas) throws InterruptedException {
            digitar("💡 Caleb (modo lâmpada): Aqui estão suas dicas:");
            for (String dica : dicas) {
                digitar("- " + dica);
                Thread.sleep(700);
            }
        }

        // ==================== TUTORIAL DE REVISÃO ====================
        static void tutorial(String titulo) throws InterruptedException {
            digitar("\n📘 Caleb: Revisando o ensinamento sobre " + titulo + "...");
            Thread.sleep(800);
            switch (titulo) {
                case "Decimal → Binário" -> digitar("Você divide o número por 2 e anota os restos. Depois, lê os restos de baixo para cima.");
                case "Binário → Decimal" -> digitar("Cada dígito binário vale uma potência de 2. Some apenas onde tiver 1.");
                case "Decimal → Octal" -> digitar("Divida o número por 8, anote os restos e leia de baixo para cima.");
                case "Octal → Decimal" -> digitar("Cada dígito octal é multiplicado por potências de 8, da direita para a esquerda.");
                case "Conversão Combinada" -> digitar("Primeiro transforme em binário, depois use o mesmo número para calcular em octal.");
            }
        }

        // ==================== RESULTADO FINAL ====================
        static void resultadoFinal() throws InterruptedException {
            digitar("\n📊 Resultado Final:");
            digitar("Você acertou " + pontuacao + " de 5 questões.");

            if (pontuacao == 5)
                digitar("Caleb: Excelente! Você dominou os sistemas. Vamos seguir!");
            else if (pontuacao >= 3)
                digitar("Caleb: Bom trabalho! Mas vamos revisar antes de continuar.");
            else
                digitar("Caleb: Parece que precisamos repetir o treinamento. Não desanime!");
        }

        // ==================== MÉTODO DE DIGITAÇÃO LENTA ====================
        static void digitar(String texto) throws InterruptedException {
            for (char c : texto.toCharArray()) {
                System.out.print(c);
                Thread.sleep(20); // controla a velocidade da "fala" do Caleb
            }
            System.out.println();
            Thread.sleep(500);

        }
    }



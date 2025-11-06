package testesomjava;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;

//Para adicionar o som, precisa ter os dois arquivos .wav no mesmo diretorio do arquivo .jar, utilizado para abrir o programa

public class TesteSom2 {

    static Scanner sc = new Scanner(System.in);
    static int pontuacao = 0;

    public static void main(String[] args) throws InterruptedException {
        inicio();
    }

    // ==================== INÍCIO DO JOGO ====================
    static void inicio() throws InterruptedException {
        digitar("Caleb: Ei! Antes de prosseguirmos, gostaria de fazer um mini teste para verificar o seu entendimento?");
        digitar("Digite 'Sim' para iniciar ou 'Não' para pular e seguir com o gameplay.");
        String escolha = sc.nextLine().trim().toLowerCase();

        if (escolha.equals("sim")) {
            miniTeste();
        } else {
            digitar("Caleb: Tudo bem, piloto. Vamos continuar o gameplay.");
            salas(); // vai direto pro jogo
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
        salas();
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
                tocarSom("acerto.wav"); // ✅ som de acerto
                digitar("✅ Caleb: Excelente! Você acertou!");
                pontuacao++;
                acertou = true;
            } else {
                tocarSom("erro.wav"); // ❌ som de erro
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
                        tentativas = 0;
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

    // ==================== TUTORIAL ====================
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

    // ==================== DIGITAÇÃO LENTA ====================
    static void digitar(String texto) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            Thread.sleep(20);
        }
        System.out.println();
        Thread.sleep(400);
    }

    // ==================== TOCAR SOM ====================
    static void tocarSom(String nomeArquivo) {
        try {
            File arquivo = new File(nomeArquivo);
            if (arquivo.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.out.println("[Som não encontrado: " + nomeArquivo + "]");
            }
        } catch (Exception e) {
            System.out.println("[Erro ao reproduzir som: " + e.getMessage() + "]");
        }
    }

    // ==================== SALAS ====================
    static void salas() {
        Scanner input = new Scanner(System.in);

        System.out.println("CALEB: Piloto, você conseguiu ligar a nave!");
        System.out.println("Agora a TADS1 já sabe onde estamos e está tentando impedir a viagem!");
        System.out.println("Precisamos sair do planeta antes que o exército dela nos alcance!");
        System.out.println("\nATENÇÃO, PILOTO! A NAVE ESTÁ SOB ATAQUE!");
        System.out.println("ALGUMAS DAS SALAS FORAM DANIFICADAS. REALIZE TAREFAS EM CADA UMA DELAS PARA PROSSEGUIRMOS!\n");

        String[] salas = {
                "SALA DE ENERGIA", "SALA DO MOTOR", "SALA DE OXIGÊNIO", "SALA DE COMUNICAÇÃO",
                "SALA DAS CÂMERAS", "SALA DO SISTEMA CENTRAL", "SALA DO REATOR", "MÓDULO DE POUSO"
        };

        for (int sala = 0; sala < salas.length; sala++) {
            executarSala(sala, input);
        }

        System.out.println("\nCALEB: PARABÉNS, PILOTO! TODAS AS SALAS FORAM RESTAURADAS!");
        System.out.println("A TERRA ESTÁ SEGURA GRAÇAS A VOCÊ!");
        System.out.println("~~~~~~ MISSÃO CONCLUÍDA ~~~~~~");
    }

    static void executarSala(int sala, Scanner input) {
        String pergunta = "", respostaCorreta = "", msgCorreta = "", msgErro = "";

        switch (sala) {
            case 0 -> {
                System.out.println("CALEB: ATENÇÃO, PILOTO! A SALA DE ENERGIA FOI DANIFICADA!");
                pergunta = "Converta o número 25 (decimal) para binário: ";
                respostaCorreta = "11001";
                msgCorreta = "CALEB: PARABÉNS! A ENERGIA DA NAVE FOI RESTAURADA!";
                msgErro = "FALHA NO SISTEMA, TENTE NOVAMENTE!";
            }
            case 1 -> {
                System.out.println("CALEB: A SALA DO MOTOR FOI INVADIDA!");
                pergunta = "Converta o número 101101 (binário) para decimal: ";
                respostaCorreta = "45";
                msgCorreta = "CALEB: PARABÉNS! MOTORES CONSERTADOS!";
                msgErro = "MOTOR COM SOMENTE 20% FUNCIONANDO!";
            }
            case 2 -> {
                System.out.println("CALEB: O SISTEMA DE OXIGÊNIO FOI CORROMPIDO!");
                pergunta = "Converta o número 10100 (binário) para decimal: ";
                respostaCorreta = "20";
                msgCorreta = "CALEB: PARABÉNS! SISTEMAS DE OXIGÊNIO FUNCIONANDO!";
                msgErro = "OXIGÊNIO COM SOMENTE 45% DE VIDA ÚTIL!";
            }
            case 3 -> {
                System.out.println("CALEB: NOSSAS COMUNICAÇÕES FORAM CORTADAS!");
                pergunta = "Converta o número 40 (decimal) para binário: ";
                respostaCorreta = "101000";
                msgCorreta = "CALEB: MUITO BEM! CONSEGUIMOS NOVAMENTE NOS COMUNICAR!";
                msgErro = "A COMUNICAÇÃO AINDA FALHA!";
            }
            case 4 -> {
                System.out.println("CALEB: A SALA DAS CÂMERAS FOI INVADIDA!");
                pergunta = "Converta o número 21 (decimal) para octal: ";
                respostaCorreta = "25";
                msgCorreta = "CALEB: PERFEITO! PRIVACIDADE RESTAURADA!";
                msgErro = "CÂMERAS AINDA DOMINADAS!";
            }
            case 5 -> {
                System.out.println("CALEB: VÍRUS DETECTADO NO SISTEMA CENTRAL!");
                pergunta = "Converta o número 10011 (binário) para decimal: ";
                respostaCorreta = "19";
                msgCorreta = "CALEB: VÍRUS EXTERMINADO!";
                msgErro = "SISTEMAS TRAVADOS!";
            }
            case 6 -> {
                System.out.println("CALEB: A TADS1 ESTÁ TENTANDO DESTRUIR O REATOR!");
                pergunta = "Converta o número 11110 (binário) para decimal: ";
                respostaCorreta = "30";
                msgCorreta = "CALEB: REATOR ESTABILIZADO!";
                msgErro = "REATOR INSTÁVEL!";
            }
            case 7 -> {
                System.out.println("CALEB: O MÓDULO DE POUSO ESTÁ DANIFICADO!");
                pergunta = "Converta o número 15 (decimal) para octal: ";
                respostaCorreta = "17";
                msgCorreta = "CALEB: MÓDULO DE POUSO FUNCIONANDO! MISSÃO CONCLUÍDA!";
                msgErro = "SISTEMAS DE POUSO INOPERANTES!";
            }
        }

        int erros = 0;
        boolean acertou = false;

        while (!acertou) {
            System.out.print(pergunta);
            String resposta = input.next();

            if (resposta.equals(respostaCorreta)) {
                tocarSom("acerto.wav");
                System.out.println(msgCorreta);
                acertou = true;
            } else {
                tocarSom("erro.wav");
                erros++;
                System.out.println(msgErro);

                if (erros == 2) {
                    System.out.println("VOCÊ ERROU DUAS VEZES! REPITA A TAREFA!");
                    erros = 0;
                }
            }
        }

        System.out.println("******** RETORNANDO AO PAINEL DE SALAS ********\n");
    }
}

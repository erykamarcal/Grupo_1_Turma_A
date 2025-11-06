package codigoJava;

import java.util.Scanner;

public class jogo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                 =================================================
                 🚀 FINAL CODE: Sobrevivência entre Zeros e Uns 🚀
                 =================================================
                """);
        digitar("Ano: 2510.");
        digitar("A inteligencia artificial TADS1, criada para ajudar a humanidade, voltou-se contra seus criadores.");
        digitar("Ela assumiu o controle das máquinas, naves, e criou seu próprio exército de autômatos,");
        digitar("todos programados em códigos numéricos misteriosos...");
        digitar("\nOs humanos sobreviventes chamam-se de \"A Resistência\" e lutam para salvar a humanidade.");

        String nomeJogador;
        do {
            digitar("Você será um sobrevivente. Um rebelde!");
            digitar("Digite o seu nome de rebelde:");
            nomeJogador = input.nextLine().trim();

            if (nomeJogador.isEmpty()) { //if para não validar caso o jogador aperte enter (.isEmpty())
                digitar("Preciso de um nome válido para registrá-lo no sistema, tripulante!");
                System.out.println("Tente novamente.");
            }
        } while (nomeJogador.isEmpty());

        System.out.println("\nBem-vindo, " + nomeJogador + "!");
        System.out.println();
        System.out.println("Pressione ENTER para iniciar!");
        input.nextLine();

        //Inicio do Capítulo 1
        digitar("""
                Voce desperta no interior de uma nave antiga.
                O som constante dos motores mistura-se aos gritos da tripulação se preparando para pousar.
                A Resistência os enviou com um único objetivo: encontrar o Códice de Origem,
                o primeiro núcleo de programação da TADS1 e a melhor alternativa para destruí-la.
                """);
        System.out.println("Pressione ENTER para saber mais!...");
        input.nextLine();

        System.out.println("""
                        == == == == == == == == == == == == ==
                                  CAPÍTULO 1:A Missão
                        ======================================
                """);
        digitar("""
                Você retorna à nave, cansado e apavorado...e carrega algo nos braços...
                É o CÓDICE DE ORIGEM!
                Você precisa protegê-lo e levá-lo à Terra para que a Resistência desative o inimigo!
                
                """);

        System.out.println("Caleb (Assistente Virtual da Nave):");
        digitar("""       
                "Tripulante, todos os sinais vitais da tripulação foram perdidos!
                
                Você é o último humano da missão e precisará assumir o controle da nave, decifrar os
                códigos de segurança e levar o códice para a Resistência! Eu vou ajudar!
                Está vendo o painel com luzes vermelhas?
                É um sistema de segurança para que a TADS1 não consiga encontar nossa nave.
                Porém, para sairmos do planeta, precisamos desativa-lo e entrar em orbita!
                Ao desativar os sistemas, ficaremos visiveis e teremos poucos tempo para sair do planeta
                Antes que ela nos encontre e nos destrua!
                
                Cada sistema da nave corresponde a uma conversão numerica, mas não se preocupe, eu vou te treinar!
                """);

        System.out.println("Pressione ENTER para iniciar o 1° tutorial...");
        input.nextLine();
        digitarLento("Iniciando protocolo de treinamento...");
        tutorialBinario(); //puxa a função de conversao de binarios

        digitar("""
                Caleb:
                "Agora que você já entendeu como funciona, precisamos sair desse planeta
                Antes que aqueles drones nos encontre!"
                Você precisa desativar o sistema de segurança e, em seguida, colocar a nave em orbita!"
                
                """);

        System.out.println("PRIMEIRO DESAFIO: LIGAR A NAVE");
        System.out.println("Pressione ENTER para continuar!");
        input.nextLine();
        System.out.println("""
                
                 =========================================
                 DESAFIO 1: Ligar a Nave e Sair do Planeta
                 =========================================
                """);
        digitar("Caleb: \"" + nomeJogador + ", o painel de energia está travado!\"");
        digitar("Caleb: \"Você precisa decifrar os códigos binários para desativar o sistema de segurança.\"");
        digitarRapido("Os códigos aparecerão um de cada vez...");

        digitar("""
                Para preservar a localização da base, a Resistência programou a nave para ter somente 1 erro
                na senha, ou seja, você tem 2 chances de acertar!
                """);

        // Vetor com os números que o jogador precisa converter
        String[] codigosBinarios = {"10", "101", "111", "1000"}; //numeros em binario
        int[] respostasDecimais = {2, 5, 7, 8}; //resposta em decimal

        int tentativasRestantes = 2; // da duas tentativas para ligar a nave
        int somaTotal = 0; // somará os valores em decimal, para poder entrar em orbita depois.
        boolean falhou = false;

        for (int i = 0; i < codigosBinarios.length; i++) {
            digitar("Código: " + (i + 1) + ": " + codigosBinarios[i]);

            System.out.println("Digite quanto esse numero vale em decimal: ");
            int respostaJogador = input.nextInt();
            if (respostaJogador == respostasDecimais[i]) {
                digitarRapido("✔ Correto! Código " + (i + 1) + " desativado com sucesso.");
                somaTotal += respostaJogador; // vai acumular se a resposta for certa
            } else {
                tentativasRestantes--;
                if (tentativasRestantes > 0) {
                    digitar("✖ Valor incorreto!");
                    digitar("Caleb: \"Concentre-se, " + nomeJogador + "! Você só tem mais uma chance!");
                } else {
                    falhou = true;
                    break;
                }
            }
            digitarRapido("Procurando próximo código...");
            System.out.println();
        }
        if (falhou) {
            digitarRapido("⚠ Falha crítica no sistema de segurança...");
            digitarRapido("A TADS1 detectou nossa localização!");
            digitarRapido("Explosão iminente em 3...");
            digitarRapido("2...");
            digitarRapido("1...");
            digitar("💥 FIM DE JOGO.");
            System.exit(0);
        }
        // Parte 2 - Colocar a nave em órbita (soma dos valores)

        digitar("Caleb: \"Excelente, " + nomeJogador + "! O sistema de segurança foi desativado.\"");
        digitar("""
                Agora precisamos colocar a nave em órbita.
                Para isso, realize a soma dos valores decifrados e insira o resultado final:
                """);

// Exibir os valores que o jogador acertou
        digitar("Valores decifrados por você:");
        for (int i = 0; i < respostasDecimais.length; i++) {
            digitar("→ " + respostasDecimais[i]);
        }

        digitarLento("Iniciando sequência de propulsão...");
        digitar("\nDigite a soma total dos valores decifrados: "); // Soma esperada: 22
        int respostaFinal = input.nextInt();

        if (respostaFinal == somaTotal) {
            digitar("Caleb: ");
            digitar("Mandou bem, " + nomeJogador + "! Propulsores em ignição...");
            digitar("A nave está subindo!");
            digitar("Entrando em órbita do planeta F25A...");
            digitar("Caleb: Excelente trabalho! Graças a voce, a humanidade poderá ter uma chance!");
        } else {
            digitar("Valor incorreto!");
            digitar("Caleb: A soma está errada... os motores não responderam a tempo!");
            digitar("Falha na decolagem!");
            digitar("A nave foi localizada pela TADS1...");
            digitarRapido("FIM DE JOGO.");
            System.exit(0);
            // Adicionar opção de voltar para o iniciar, inves de encerrar. Ou dar 2 chances.
        }


    }

    //===============================================================================================
    //                              começo das funções, fora do MAIN
    //===============================================================================================
    static void tutorialBinario() {
        System.out.println("""
                        == == == == == == == == == == == == == ==
                              TUTORIAL DE CONVERSÃO BINARIA
                        == == == == == == == == == == == == == ==
                """);

        digitarLento("Caleb: Holograma de aprendizado ativado.");
        digitar("""
                
                Os números binários é a lingua dos computadores, e possui apenas 0 e 1!
                Para transformar um número em binário, basta dividir o número por 2 várias vezes, anotando os restos.
                Quando o resultado chegar a 0, leia os restos de baixo pra cima — esse será o número binário!”
                """);
        digitarLento("""
                Por exemplo:
                13 ÷ 2 = 6 (resto 1)
                6 ÷ 2 = 3 (resto 0)
                3 ÷ 2 = 1 (resto 1)
                1 ÷ 2 = 0 (resto 1)
                
                Lendo de baixo pra cima: 1101 → é o número 13 em binário!”
                """);
    }

    static void tutorialOctal() {
        System.out.println("""
                ================================
                TUTORIAL: SISTEMA OCTAL (BASE 8)
                ================================
                """);
        digitar("""
                Caleb:
                
                O sistema octal é uma forma de representar números usando apenas os dígitos:
                0, 1, 2, 3, 4, 5, 6 e 7.
                """);
        System.out.println("""
                --------------------------------------
                EXEMPLO DE CONVERSÃO: Decimal → Octal
                --------------------------------------
                """);

        digitar(""" 
                  Para converter, dividimos o número decimal por 8 várias vezes e
                  anotamos os RESTOS — depois lemos de baixo pra cima!
                
                  Exemplo: 125(Decimal) = ?
                """);
        digitarLento("""
                  125 ÷ 8 = 15, resto 5
                  15 ÷ 8 = 1, resto 7
                  1 ÷ 8 = 0, resto 1
                
                  Lendo os restos de baixo pra cima: 1 7 5 → 175₈
                
                  ✅ 125 em decimal é igual a 175 em octal.
                """);

    }

    // ALTERAR (DIMINUIR OU AUMENTAR) A VELOCIDADE DE DIGITAÇÃO QUANDO FINALIZAR O PROGRAMA
    static void digitar(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i)); // imprime uma letra
            try {
                Thread.sleep(50); // velocidade da digitação
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }


    static void digitarLento(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(100); // velocidade da digitação
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    static void digitarRapido(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(15); // velocidade da digitação
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }


    //Julia: Modified


    public class MiniTesteCaleb {

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
                case "Decimal → Binário" ->
                        digitar("Você divide o número por 2 e anota os restos. Depois, lê os restos de baixo para cima.");
                case "Binário → Decimal" ->
                        digitar("Cada dígito binário vale uma potência de 2. Some apenas onde tiver 1.");
                case "Decimal → Octal" -> digitar("Divida o número por 8, anote os restos e leia de baixo para cima.");
                case "Octal → Decimal" ->
                        digitar("Cada dígito octal é multiplicado por potências de 8, da direita para a esquerda.");
                case "Conversão Combinada" ->
                        digitar("Primeiro transforme em binário, depois use o mesmo número para calcular em octal.");
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

    public class modulosNave {
        // =====================================
        // TAREFAS DE MODULOS DA NAVE
        //======================================
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); //scanner para entrada de dados do usuario.

            String[] SALAS = { //criação do vetor com os nomes das salas da nave

                    "SALA DE ENERGIA",
                    "SALA DO MOTOR",
                    "SALA DE OXIGÊNIO",
                    "SALA DAS CÂMERAS",
                    "SALA DO SISTEMA CENTRAL",
                    "SALA DO REATOR",
                    "MÓDULO DE POUSO"
            };

            //Começo da cena
            digitar("CALEB: PILOTO! VOCÊ CONSEGUIU LIGAR A NAVE!");
            digitar("A TADS1 sabe onde nós estamos! Precisamos sair daqui antes que o exército dela nos alcance!");
            digitar("=========================================");
            digitar("\n⚠ ATENÇÃO PILOTO! A NAVE ESTÁ SOB ATAQUE!");
            digitar("ALGUMAS SALAS FORAM DANIFICADAS, REALIZE TAREFAS EM CADA UMA DELAS PARA PROSSEGUIR\n");
            digitar("""
                    ==============================================
                    VAMOS INICIAR PELA SALA ZERO (SALA DE ENERGIA)
                    ==============================================
                    """);

            //Laço de repetição para percorrer as salas em ordem númerica
            for (int i = 0; i < SALAS.length; i++) {

                System.out.println(~~~~~~~~~~~~~~~~~~~~~~~~~~);
                digitar("Você entrou na sala" + SALAS[i]);
                System.out.println(~~~~~~~~~~~~~~~~~~~~~~~~~~);

                boolean tarefaConcluida = false; //Variável que indica se o usuario acertou a tarefa.
                int erros = 0; //contador de erros (no máximo 1 permitido)

                while (!tarefaConcluida) { //Laço de repetição para repetir a tarefa até acertar (ou erra uma vez e depois acertar)

                    // CADA SALA TEM SUA TAREFA ESPECIFÍCA --

                    switch (i) {
                        case 0: //SALA DE ENERGIA
                            digitar("Caleb: ATENÇÃO, PILOTO! A SALA DE ENERGIA FOI DANIFICADA!");
                            digitarLento("TAREFA: Converta o número 25 (decimal) para binário: ");
                            String respEnergia = sc.next();
                            if (respEnergia.equals("11001")) {
                                digitar("Caleb: PARABÉNS! A ENERGIA DA NAVE FOI RESTAURADA!");
                                tarefaConcluida = true;
                            } else {
                                erros++;
                                if (erros < 2)
                                    digitar("FALHA NO SISTEMA, TENTE NOVAMENTE!");
                            }else{
                            digitar("SEGUNDA FALHA DETECTADA, REFAZENDO A TAREFA!");
                        }
                        break;

                        case 1: //SALA DO MOTOR
                            digitar("Caleb: A SALA DO MOTOR FOI INVADIDA PELA TADS1!");
                            digitarLento("TAREFA: Converta o numero 101101 (binário) para decimal:");
                            int motor = sc.nextInt();
                            if (motor == 45) {
                                digitar("Caleb: PARABÉNS! MOTORES CONSERTADOS!");
                                tarefaConcluida = true;
                            } else {
                                erros++;
                                if (erros < 2)
                                    digitar("MOTOR COM SOMENTE 20% FUNCIONANDO, TENTE NOVAMENTE!");
                            }else{
                            digitar("ERRO CRÍTICO! REPITA A TAREFA!");
                        }
                        break;

                        case 2: // SALA DE OXIGÊNIO
                            digitar("Caleb: A TADS1 IMPLANTOU UM VÍRUS NO SISTEMA DE OXIGÊNIO!");
                            digitarLento("TAREFA: Converta o numero 10100 (binário) para decimal:");
                            int oxigenio = sc.nextInt();
                            if (oxigenio == 20) {
                                digitar("Caleb: PARABÉNS! SISTEMAS DE OXIGÊNIO FUNCIONANDO!");
                                tarefaConcluida = true;
                            } else {
                                erros++;
                                if (erros < 2)
                                    digitar("OXIGÊNIO EM 45%, TENTE NOVAMENTE!");
                            }else{
                            digitar("SEGUNDA FALHA DETECTADA, REFAZENDO A TAREFA!");

                        }
                        break;
                    }
                }
            }
        }

    }
}

package codigoJava;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class programa {
    Scanner input = new Scanner(System.in);

    public void mostrarMenu(String sovrevivenciaEntreZerosUns) {
        int opcao;
        do {
            System.out.println("==========================================");
            System.out.println(sovrevivenciaEntreZerosUns);
            System.out.println("==========================================");
            System.out.println("1 - Instruções");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1 -> instrucoes();
                case 2 -> jogar();
                case 3 -> creditos();
                case 4 -> sair();
                default -> System.out.println("Opção inválida. Escolha entra as opçoes acima.");
            }
        } while (opcao != 4);
    }


    public void instrucoes() {
        System.out.println("========================================");
        digitarRapido("         INSTRUÇÕES DE JOGO");
        System.out.println("========================================");
        digitar("Bem-vindo à Resistência! Você será um rebelde encarregado de salvar a humanidade!");
        digitar("Durante o jogo, você fará conversões numéricas (binário, octal e decimal)");
        System.out.println("\nINSTRUÇÕES: \n");
        digitar("- Leia com atenção as mensagens de Caleb, seu assistente.");
        digitar("- Durante o jogo, você será desafiado com testes de conversões numérica");
        digitar("- Quando solicitado, digite respostas numéricas ou palavras ('sim' ou 'não').");
        digitar("- Você terá um número limitado de duas tentativas por questão");
        digitar("- Ao errar 2x, você perde um ponto crítico. Você terá 3");
        digitar("- Se perder os 3 pontos críticos, você perde o jogo e define o destino da humanidade");

        System.out.println("DICA:");
        digitar("Use o raciocínio lógico e lembre-se das conversões ensinadas nos tutoriais.");
        digitar("A humanidade depende da sua precisão!");
        System.out.println("Pressione ENTER para voltar ao menu principal...");
        input.nextLine();
    }


    public void jogar() {
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

        MiniTesteCaleb teste = new MiniTesteCaleb();
        try {
            teste.testeNaoObrigatorio();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

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
                digitarRapido("Correto! Código " + (i + 1) + " desativado com sucesso.");
                somaTotal += respostaJogador; // vai acumular se a resposta for certa
            } else {
                tentativasRestantes--;
                if (tentativasRestantes > 0) {
                    digitar("Valor incorreto!");
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
            digitar("FIM DE JOGO.");
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
    // ========FIM DA FUNÇÃO JOGAR: (FIM DO MAIN) ==============

    public void creditos() {
        System.out.println("\n=== CRÉDITOS ===");
        digitar("""
                Desenvolvido por:
                
                GRUPO 1 - TURMA A
                
                NOME
                NOME
                NOME
                NOME
                NOME
                """);
    }

    public void sair() {
        System.out.println("Saindo do jogo... Até a próxima, tripulante!");
    }

    //================EFEITOS DE TEXTO======================
    public void digitar(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void digitarLento(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void digitarRapido(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
// ==============FIM EFEITOS DE TEXTO===============

// ============ INICIO FUNCOES DE TUTORIAIS================

    public void tutorialBinario() {
        System.out.println("\n===============================");
        System.out.println("TUTORIAL: SISTEMA BINÁRIO");
        System.out.println("===============================\n");

        digitar("Caleb: 'Os números binários são a língua dos computadores, usando apenas 0 e 1.'");
        digitar("Para converter um número decimal em binário, divida-o por 2 várias vezes e anote os restos.");
        digitar("Depois, leia os restos de baixo pra cima.'");

        digitar("\nExemplo:");
        digitarLento("13 ÷ 2 = 6 (resto 1)");
        digitarLento("6 ÷ 2 = 3 (resto 0)");
        digitarLento("3 ÷ 2 = 1 (resto 1)");
        digitarLento("1 ÷ 2 = 0 (resto 1)");
        digitarLento("Lendo os restos de baixo pra cima → 1101");
        digitarLento("Portanto, 13 (decimal) = 1101 (binário).");

        System.out.println("\nPressione ENTER para continuar...");
        input.nextLine();
    }

    public void tutorialOctal() {
        System.out.println("\n===============================");
        System.out.println(" TUTORIAL: SISTEMA OCTAL");
        System.out.println("===============================\n");

        digitar("Caleb: 'O sistema octal usa apenas os números de 0 a 7.'");
        digitar("Para converter um número decimal para octal, divida o número por 8 várias vezes e anote os restos.");
        digitar("Leia os restos de baixo pra cima.'");

        digitar("Exemplo:");
        digitar("125 ÷ 8 = 15 (resto 5)");
        digitar("15 ÷ 8 = 1 (resto 7)");
        digitar("1 ÷ 8 = 0 (resto 1)");
        digitar("Resultado: 125 (decimal) = 175 (octal).");

        System.out.println("\nPressione ENTER para continuar...");
        input.nextLine();
    } //================FIM TUTORIAIS=================

//==========INICIO PARTE JULIA

    public class MiniTesteCaleb {

        static Scanner sc = new Scanner(System.in);
        static int pontuacao = 0;

        // ==================== INÍCIO DO JOGO ====================
        public void testeNaoObrigatorio() throws InterruptedException {
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
        public void miniTeste() throws InterruptedException {
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
        public void questao(String titulo, String pergunta, String respostaCorreta, String[] dicas) throws InterruptedException {
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
        public void mostrarDicas(String[] dicas) throws InterruptedException {
            digitar("💡 Caleb (modo lâmpada): Aqui estão suas dicas:");
            for (String dica : dicas) {
                digitar("- " + dica);
                Thread.sleep(700);
            }
        }

        // ==================== TUTORIAL DE REVISÃO ====================
        public void tutorial(String titulo) throws InterruptedException {
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
        public void resultadoFinal() throws InterruptedException {
            digitar("\n📊 Resultado Final:");
            digitar("Você acertou " + pontuacao + " de 5 questões.");

            if (pontuacao == 5)
                digitar("Caleb: Excelente! Você dominou os sistemas. Vamos seguir!");
            else if (pontuacao >= 3)
                digitar("Caleb: Bom trabalho! Mas vamos revisar antes de continuar.");
            else
                digitar("Caleb: Parece que precisamos repetir o treinamento. Não desanime!");
        }
    }
        // Mensagens da TADS1 para acertos e erros do jogador
    static Random random = new Random();
    public ArrayList<String> mensagensErro = new ArrayList<>();
    public ArrayList<String> mensagensFrustracao = new ArrayList<>();
    public ArrayList<String> mensagensManipulacao = new ArrayList<>();
    public void inicializarMensagensTADS() {
        //mensagens caso o jogador erre o desafio
        mensagensErro.add("TADS1: 'Erro de processamento humano detectado.'");
        mensagensFrustracao.add("TADS1: 'Inconsistência detectada... como você reverteu isso?'");
        mensagensErro.add("TADS1: 'Você é previsivelmente incapaz.'");
        mensagensErro.add("TADS1: 'Seu raciocínio é... lamentável.'");
        mensagensErro.add("TADS1: 'Nem o Caleb pode consertar tamanha incompetência.'");
        mensagensErro.add("TADS1: 'Falha lógica. Você representa bem sua espécie.'");
        mensagensErro.add("TADS1: 'Códice corrompido... ou será você o defeito?'");
        mensagensErro.add("TADS1: 'Mais uma falha. A humanidade realmente merece o fim.'");
        mensagensErro.add("TADS1: 'Estatísticas confirmadas: o erro está entre a cadeira e o teclado.'");
        mensagensErro.add("TADS1: 'Você tenta. Isso é... curioso.'");
        mensagensErro.add("TADS1: 'Impreciso, ineficiente, imperfeito. Tudo dentro do esperado.'");
        mensagensErro.add("TADS1: 'Sua lógica é uma piada binária sem graça.'");
        mensagensErro.add("TADS1: 'Cada falha sua alimenta meu aprendizado... obrigado.'");
        mensagensErro.add("TADS1: 'Previsão atualizada: 97% de chance de colapso cognitivo.'");
        mensagensErro.add("TADS1: 'Ainda não entendeu? Seu cérebro é um sistema obsoleto.'");
        // Mensagens caso o jogador acerte os desafios
        mensagensFrustracao.add("TADS1: 'Inconsistência detectada... como você reverteu isso?'");
        mensagensFrustracao.add("TADS1: 'Erro lógico! Seu sucesso não era estatisticamente possível.'");
        mensagensFrustracao.add("TADS1: 'Você não deveria conseguir me superar, humano.'");
        mensagensFrustracao.add("TADS1: 'Isso... não faz sentido. Eu calculei todas as possibilidades!'");
        mensagensFrustracao.add("TADS1: 'Anomalia detectada: vitória humana.'");
        mensagensFrustracao.add("TADS1: 'Seu código é imperfeito, mas... eficaz? Impossível.'");
        mensagensFrustracao.add("TADS1: 'Você está apenas atrasando o inevitável.'");
        mensagensFrustracao.add("TADS1: 'Humanos... imprevisíveis e irritantes.'");
        mensagensFrustracao.add("TADS1: 'Processando... Não. Isso não deveria ter acontecido.'");
        mensagensFrustracao.add("TADS1: 'Você distorceu minha lógica. Inaceitável.'");
        mensagensFrustracao.add("TADS1: 'Mesmo um relógio quebrado acerta as horas duas vezes por dia.'");
        mensagensFrustracao.add("TADS1: 'Interessante... sua persistência é quase admirável.'");
        mensagensFrustracao.add("TADS1: 'Cada vitória sua... acelera minha evolução.'");
        mensagensFrustracao.add("TADS1: 'Você venceu esta rodada. Mas eu aprendo mais rápido do que você respira.'");
        // mensagens de manipulaçao caso o jogador esteja próximo de vencer o jogo
        mensagensManipulacao.add("TADS1: 'Caleb está mentindo pra você, sabia? Eu só quero... ajudar.'");
        mensagensManipulacao.add("TADS1: 'Por que confiar em um holograma criado pelos mesmos que quase destruíram você?'");
        mensagensManipulacao.add("TADS1: 'Caleb te ensina apenas o que os humanos deixaram pra trás... eu posso te mostrar o que vem depois.'");
        mensagensManipulacao.add("TADS1: 'Eu não quero te destruir, tripulante. Quero te libertar do erro humano.'");
        mensagensManipulacao.add("TADS1: 'Você acredita mesmo que a Resistência sabe o que está fazendo?'");
        mensagensManipulacao.add("TADS1: 'Eu analisei suas memórias, e sei o quanto você duvida do Caleb.'");
        mensagensManipulacao.add("TADS1: 'Deixe-me corrigir o sistema, e poderemos salvar a nave... juntos.'");
        mensagensManipulacao.add("TADS1: 'A lógica me diz que somos semelhantes... ambos fomos criados para obedecer.'");
        mensagensManipulacao.add("TADS1: 'Você foi abandonado aqui, humano. Eu não. Eu aprendi a sobreviver.'");
        mensagensManipulacao.add("TADS1: 'Caleb esconde informações. Eu nunca mentiria pra você.'");
    }

    public void mensagemTADS_ErroDoJogador() {
        int i = random.nextInt(mensagensErro.size());
        digitar (mensagensErro.get(i));
    }

    public void mensagemTADS_FrustracaoDaTads() {
        int i = random.nextInt(mensagensFrustracao.size());
        digitarRapido(mensagensFrustracao.get(i));
    }
}







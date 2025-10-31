package codigoJava;

import java.util.Scanner;

public class jogo {
    static void introducao() {
        System.out.println("""
                 =============================================================
                          FINAL CODE: Sobrevivência entre Zeros e Uns
                 =============================================================
                
                 Ano: 2510.
                 A Inteligência Artificial TADS-1 se voltou contra a humanidade.
                 Você e um pequeno grupo partirá em uma missão até o planeta F25A,
                 onde acredita-se estar o Códice de Origem — a primeira programação da TADS-1!
                """);
        System.out.println("""
                Você desperta no interior de uma nave antiga.
                O som constante dos motores mistura-se ao eco distante de um alarme.
                A Resistência te enviou com um único objetivo: encontrar o Códice de Origem
                """);
    }

    static void tutorialConversaoBinaria() { //Tutorial de conversão, precisa editar ainda
        System.out.println("""
                        == == == == == == == == == == == == == == == == == == == == == == == =
                                        TUTORIAL DE CONVERSÃO BINARIA
                        == == == == == == == == == == == == == == == == == == == == == == == =
                
                Local:Sala de Comando — Holograma de aprendizado ativado.
                
                Caleb:
                "Eu vou te ensinar como funciona as conversões com numeros binarios (0 e 1)
                
                Caleb:
                Os números binários é a lingua em que os computadores se comunicam, e possui apenas 0 e 1!
                Para transformar um número decimal em binário,
                basta dividir o número por 2 várias vezes, anotando os restos.
                Quando o resultado chegar a 0, leia os restos de baixo pra cima —
                esse será o número binário!”
                
                Por exemplo:
                13 ÷ 2 = 6 (resto 1)
                6 ÷ 2 = 3 (resto 0)
                3 ÷ 2 = 1 (resto 1)
                1 ÷ 2 = 0 (resto 1)
                
                Lendo de baixo pra cima: 1101 → é o número 13 em binário!”
                
                """);
    }

    static String nomeJogador(Scanner input) { //função para o nome do Jogador
        String nome;
        input.nextLine();

        do {
            System.out.print("Como devo chamar você, piloto? Digite seu nome: ");
            nome = input.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("""
                        Caleb:
                        "Preciso de um nome válido para registrá-lo no sistema, tripulante!"
                        Tente novamente.
                        """);
            }

        } while (nome.isEmpty());

        System.out.println("\nBem-vindo, " + nome + "!");
        System.out.println();
        return nome;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        introducao(); // Vem a função para introduzir o mundo.

        System.out.println("\nPressione ENTER para saber mais!...");
        input.nextLine();

        System.out.println("""
                        == == == == == == == == == == == == == == == == == == == == == == == =
                                                  CAPÍTULO 1:A Missão
                        ======================================================================
                """);

        System.out.println("""
                Você retorna à nave, cansado e apavorado...e carrega algo nos braços.
                É o CÓDICE DE ORIGEM —o núcleo que pode destruir a TADS - 1 e salvar a humanidade !
                Você precisa protegê -lo e levá -lo à Terra para que a Resistência desative o inimigo !
                """);
        System.out.println("");
        System.out.println("\nPressione ENTER continuar!...");
        input.nextLine();
        System.out.println("""
              
                Caleb (Assistente Virtual da Nave):
                
                "Tripulante, todos os sinais vitais da tripulação foram perdidos!
                Você é o último humano da missão e precisará assumir o controle da nave, decifrar os códigos de segurança
                e nos levar de volta para a Terra-02! Cada sistema da nave corresponde a uma conversão numerica,
                mas não se preocupe, eu vou te treinar!
                
                """);

        System.out.println("E ai, quer embarcar nesse desafio?");
        System.out.println("1 - Vamos jogar !");

        System.out.println("2 - Parece muito difícil...");
        System.out.println("3 - Não quero jogar. Sair.");

        int escolhaIniciarJogo;
        do {
            System.out.print("Digite sua escolha (1, 2 ou 3): ");
            escolhaIniciarJogo = input.nextInt();

            if (escolhaIniciarJogo == 1) {
                System.out.println("""
                                \n Excelente, tripulante!
                                Inicializando o jogo...
                                """);
                nomeJogador(input); // puxa funçao para pedir o nome do jogaador
                System.out.println("\nPressione ENTER para iniciar o tutorial...");
                input.nextLine();
                tutorialConversaoBinaria(); //puxa a função de conversao de binarios

            } else if (escolhaIniciarJogo == 2) {
                System.out.println("Caleb: \"Mesmo com medo, você precisa tentar!\"");
                tutorialConversaoBinaria(); //puxa a função de conversao de binarios
            } else if (escolhaIniciarJogo == 3) {
                System.out.println("""
                Negar a missão é negar o futuro da humanidade.
                Saindo do jogo...
                """);
                System.exit(0);
            } else {
                System.out.println("Opção inválida! Escolha 1, 2 ou 3.\n");
            }

        } while (escolhaIniciarJogo < 1 || escolhaIniciarJogo > 3);
    }
}

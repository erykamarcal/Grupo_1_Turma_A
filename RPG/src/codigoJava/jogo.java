package codigoJava;

import java.util.Scanner;

public class jogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
        ===============================================
          FINAL CODE: Sobrevivência entre Zeros e Uns
        ===============================================
        
        Ano: 2510. A Inteligência Artificial TADS1 se voltou contra a humanidade.
        Você e um pequeno grupo partirá em uma missão até o planeta F25A.
        """);

        // CENA INICIAL PRÉ MONTADA: JOGADOR  RETORNA À NAVE

        System.out.println("""
        Você retorna à nave, cansado e apavorado... e carrega algo nos braços.
        É o CÓDICE DE ORIGEM — o núcleo que pode destruir a TADS1 e o motivo da missão!
        """);

        //CALEB RECEBE O JOGADOR
        System.out.println("""
        Caleb (software da nave):
        "Tripulante, todos os sinais vitais da tripulação foram perdidos!
        Você é o último humano da missão e precisa assumir o controle da nave, decifrar os códigos de segurança 
        e nos levar de volta para a Terra-02! Sem decifrar os códigos a nave não funcionará!
        Mas não se preocupe, eu vou te treinar!!
        """);

        // SOLICITA O NOME
        String name;

        do {
            System.out.print("Como devo chamar você, piloto? Digite seu nome: ");
            name = input.nextLine().trim(); //trim serve para não aceitar nomes vazios!

            if (name.isEmpty()) {
                System.out.println("Caleb: \"Preciso de um nome válido para registrá-lo no sistema, tripulante!\"");
                System.out.println("Tente novamente.\n");
            }
        } while (name.isEmpty());
        System.out.println();
        System.out.println("Bem-vindo, " + name + "!");
        System.out.println();

        //CALEB APRESENTA AS REGRAS DA MISSÃO. QUERO ADICIONAR UM MENU DE "VAMOS COMEÇAR?"
        System.out.println(" MISSÃO: ");
        System.out.println("- Proteger o Códice e levá-lo à Terra para que a resistência desative a TADS1.");
        System.out.println("O QUE VOCÊ PRECISA SABER PARA VENCER: ");
        System.out.println("- Cada sistema da nave solicita uma conversão numérica diferente (ex.: decimal ⇄ binário).");
        System.out.println("- Você terá 3 chances para cada questão; errar 3 vezes em questões críticas causa perda de PONTO CRÍTICO.");
        System.out.println("- Ao perder 3 Pontos Críticos a nave explode — fim de jogo.");
        System.out.println();
    }
}

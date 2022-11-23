import java.util.Scanner;

import Node.Node;

public class start {

    static Scanner scanner = new Scanner(System.in);
    static float contBit;

    public static void main(String[] args) {

        boolean test = true;
        while (test != false) {

            contBit = 0;

            System.out.println("Escolha uma opção: ");
            System.out.println("        |1| - Comprimir Texto");
            System.out.println("        |2| - Limpar console");
            System.out.println("        |3| - Sair");
            System.out.print(" Escolher: ");

            int option = (int) scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Digite o texto a ser comprimido: ");
                    String text = scanner.next();
                    countBits(text);

                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    break;
                case 3:
                    test = false;

                    break;
                case 4:

                    break;

                default:
                    test = false;
                    break;
            }

        }

    }

    static void countBits(String text) {

        char character;
        String characterBinario;
        Node characteresTable[] = new Node[text.length()];

        for (int i = 0; i < text.length(); i++) {

            character = text.charAt(i);
            characterBinario = Integer.toBinaryString(character);
            contBit += characterBinario.length();

            int tempx = 0;

            while (characteresTable[tempx] != null && characteresTable[tempx].getCharacter() != character) {
                tempx++;
            }

            if (characteresTable[tempx] == null) {
                characteresTable[tempx] = new Node(character, characterBinario);

            } else {
                characteresTable[tempx].setFc(characteresTable[tempx].getFc() + 1);
            }

        }
        System.out.println();

        System.out.println("====================================");
        System.out.println("            Informações             ");
        System.out.println("====================================");

        System.out.println();

        System.out.println("Texto digtado; " + text);
        System.out.println("Numero total de bits: " + contBit);

        System.out.println();

        System.out.println("Tabela de caracteres e seus bits: ");

        int temp = 0;

        while (true) {

            if (temp == characteresTable.length) {
                break;
            }

            if (characteresTable[temp] == null) {
                break;
            }

            System.out.print("Indice: " + temp +
                    " - caractere: |" + characteresTable[temp].getCharacter() +
                    "| - bits: " + characteresTable[temp].getBits() +
                    " - frequencia: " + characteresTable[temp].getFc());

            System.out.println();
            temp++;
        }

        System.out.println();

        huffman huf = new huffman();
        huf.bildTree(temp, characteresTable);
        huf.imprimir();
        String comprimida = huf.stringComprim(text);

        System.out.println();
        System.out.println("------Texto comprimido------");
        System.out.println("Bits da string comprimida: " + comprimida);
        System.out.println("Número de bits da string comprimida: " + comprimida.length());
        float taxaCompressão = (float) comprimida.length() / contBit;
        System.out.println("Taxa de compressão: " + taxaCompressão);

        System.out.println();

        System.out.println("Arvore por nivel");
        huf.printNivel();

    }

}

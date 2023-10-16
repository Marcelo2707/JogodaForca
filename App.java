/* CÓDIGO DO ALEXANDRE PEREIRA E DO MARCELO NUNES */

import java.util.Random;
import java.util.Scanner;

public class App {

    private static String[] PALAVRAS = {"DESENVOLVEDOR", "CELULAR", "PROFESSOR", "ENSINAMENTO", "LER",
                                        "CHINELO", "TALHER", "JANELA", "SAPATO", "GELADEIRA", "CAMA", 
                                        "COMIDA", "ESPELHO", "CARRO" ,"ACADEMIA" , "DIRIGIR"  , "ANDAR", 
                                        "CAMINHAR" , "FUTEBOL" , "ESPORTE"};
    private static int MAX_TENTATIVAS = 6; 
    private String palavraSecreta;
    private StringBuilder letrasUsadas;
    private int tentativasRestantes;

    public App() {

        palavraSecreta = escolherPalavraAleatoria();
        letrasUsadas = new StringBuilder();
        tentativasRestantes = MAX_TENTATIVAS;

    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (tentativasRestantes > 0) {
            
            exibirForca();
            exibirPalavra();
            exibirLetrasUsadas();
            System.out.print("Digite uma letra: ");
            String entrada = scanner.next().toUpperCase();
            char letra = entrada.charAt(0);

            if (!Character.isLetter(letra)) {
                System.out.println("Por favor, digite uma letra válida.");
                continue;
            }

            if (letrasUsadas.indexOf(entrada) != -1) {
                System.out.println("Você já usou essa letra.");
                continue;
            }

            letrasUsadas.append(letra);
            if (palavraSecreta.indexOf(letra) != -1) {
                System.out.println("Letra correta!");
                if (ganhou()) {
                    System.out.println("Parabéns! Você ganhou!");
                    break;
                }

            } else {
                System.out.println("Letra incorreta.");
                tentativasRestantes--;
            }
        }

        if (tentativasRestantes == 0) {
            exibirForca();
            System.out.println("Você perdeu. A palavra era: " + palavraSecreta);
        }
        scanner.close();

    }

    private String escolherPalavraAleatoria() {

        Random random = new Random();
        return PALAVRAS[random.nextInt(PALAVRAS.length)];

    }

    private void exibirForca() {

        int partesRestantes = MAX_TENTATIVAS - tentativasRestantes;
        System.out.println("Tentativas restantes: " + tentativasRestantes);

        switch (partesRestantes) {

            case 0:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;

            case 1:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;

            case 2:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |       |");
                System.out.println("  |");
                System.out.println("__|__");
                break;

            case 3:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|");
                System.out.println("  |");
                System.out.println("__|__");
                break;

            case 4:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |");
                System.out.println("__|__");
                break;

            case 5:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |      /");
                System.out.println("__|__");
                break;

            case 6:

                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |      / \\");
                System.out.println("__|__");
                break;
            
            default:
                break;
        }
    }

    private void exibirPalavra() {

        for (char letra : palavraSecreta.toCharArray()) {

            if (letrasUsadas.indexOf(String.valueOf(letra)) != -1) {
                System.out.print(letra + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();

    }

    private void exibirLetrasUsadas() {

        System.out.println("Letras usadas: " + letrasUsadas.toString());

    }

    private boolean ganhou() {

        for (char letra : palavraSecreta.toCharArray()) {
            if (letrasUsadas.indexOf(String.valueOf(letra)) == -1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        App jogo = new App();
        jogo.jogar();
    }
}

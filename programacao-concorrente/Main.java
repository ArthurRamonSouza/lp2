import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void imprimirMatriz(int[][] matriz, int tamMatriz) {
        for (int l = 0; l < tamMatriz; l++) {
            for (int c = 0; c < tamMatriz; c++) {
                System.out.print(matriz[l][c] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        System.out.print("Digite o tamanho da matriz: ");
        Scanner scan = new Scanner(System.in);
        int tamMatriz = scan.nextInt();
        scan.close();
        
        //Variáveis
        int linha = 0;
        Random gerador = new Random();
        Thread[] threads = new Thread[tamMatriz];
        int[][] matrizA = new int[tamMatriz][tamMatriz];
        int[][] matrizB = new int[tamMatriz][tamMatriz];
        int[][] matrizAB = new int[tamMatriz][tamMatriz];

        //Populando matrizes e array
        for (int l = 0; l < tamMatriz; l++) {
            threads[l] = new Thread();
            for (int c = 0; c < tamMatriz; c++) {
                matrizA[l][c] = gerador.nextInt(0, 10);
                matrizB[l][c] = gerador.nextInt(0, 10);
            }
        }

        //Multiplicacao Concorrente
        MultiplicacaoMatrizConcorrente m = new MultiplicacaoMatrizConcorrente(matrizA, matrizB, matrizAB, tamMatriz);
        //System.out.println("Matriz A: ");
        //imprimirMatriz(matrizA, tamMatriz);
        //System.out.println("Matriz B: ");
        //imprimirMatriz(matrizB, tamMatriz);

        long start = System. currentTimeMillis();
        while(linha < tamMatriz){
            m.setLinha(linha);
            Thread t = new Thread(m);
            t.start();
            linha++;
        }
        long end = System. currentTimeMillis();

        long finalConcorrente = end - start;

        //System.out.println("Matriz AB Concorrente: ");
        //imprimirMatriz(matrizAB, tamMatriz);

        MultiplicacaoMatrizSequencial mSequencial = new MultiplicacaoMatrizSequencial(matrizA, matrizB, matrizAB, tamMatriz);
        
        mSequencial.run();
        
        //System.out.println("Matriz AB Sequencial: ");
        //imprimirMatriz(matrizAB, tamMatriz);
        System.out.println("Tempo de execucao Concorrente: " + finalConcorrente);
        System.out.println("Tempo de execucao Sequencial: " + mSequencial.getTempoDecorrido());
    }
}

import java.util.Random;
import java.util.Scanner;

public class Mainm {
    
    public static void main(String[] args) {
        System.out.print("Digite o tamanho da matriz: ");
        Scanner scan = new Scanner(System.in);
        int tamMatriz = scan.nextInt();
        scan.close();
        
        //Variáveis
        int[][] matrizA = new int[tamMatriz][tamMatriz];
        int[][] matrizB = new int[tamMatriz][tamMatriz];
        int[][] matrizAB = new int[tamMatriz][tamMatriz];


        long start = System. currentTimeMillis();
        MultiplicacaoMatrizSequencial mSequencial = new MultiplicacaoMatrizSequencial(matrizA, matrizB, matrizAB, tamMatriz);
        mSequencial.run();
        long end = System. currentTimeMillis();
        long tempoDecorrido = end - start;
        System.out.println(tempoDecorrido);
    }
}

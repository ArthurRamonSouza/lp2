public class MultiplicacaoMatrizConcorrente implements Runnable {

    private int linha, tamMatriz;
    private int[][] matrizA, matrizB, matrizAB;

    public MultiplicacaoMatrizConcorrente(int[][] A, int[][] B, int[][] AB, int tamMatriz) {
        matrizA = A;
        matrizB = B;
        matrizAB = AB;
        this.tamMatriz = tamMatriz;
    }

    public void setLinha(int l) {
        linha = l;
    }

    @Override
    public void run() {
        for (int c = 0; c < tamMatriz; c++) {
            for (int i = 0; i < tamMatriz; i++) {
                matrizAB[linha][c] += matrizA[linha][i] * matrizB[i][c];
            }
        }
    }
}
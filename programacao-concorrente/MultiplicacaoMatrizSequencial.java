public class MultiplicacaoMatrizSequencial {

    private int tamMatriz;
    private long tempoDecorrido;
    private int[][] matrizA, matrizB, matrizAB;

    public MultiplicacaoMatrizSequencial(int[][] A, int[][] B, int[][] AB, int tamMatriz) {
        matrizA = A;
        matrizB = B;
        matrizAB = AB;
    }

    public long getTempoDecorrido(){
        return tempoDecorrido;
    }

    public void run() {
        long start = System. currentTimeMillis();
        for (int l = 0; l < tamMatriz; l++) {
            for (int c = 0; c < tamMatriz; c++) {
                for (int i = 0; i < tamMatriz; i++) {
                    matrizAB[l][c] += matrizA[l][i] * matrizB[i][c];
                }
            }
        }
        long end = System. currentTimeMillis();
        tempoDecorrido = end - start;
    }
}
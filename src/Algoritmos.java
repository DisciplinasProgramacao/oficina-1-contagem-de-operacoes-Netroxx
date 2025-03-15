import java.util.Arrays;

public class Algoritmos {

    // Algoritmo 1: Soma (O(N))
    public static int soma(int[] vetor) {
        int total = 0;
        for (int elemento : vetor) {  // O(N) operações
            total += elemento;
        }
        return total;
    }

    // Algoritmo 2: Bubble Sort (O(N²))
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {  // O(N) iterações
            for (int j = 0; j < n - i - 1; j++) {  // O(N) iterações
                if (vetor[j] > vetor[j + 1]) {  // Comparação
                    // Troca
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    // Algoritmo 3: Busca Binária (O(log N))
    public static int buscaBinaria(int[] vetor, int elemento) {
        int esquerda = 0;
        int direita = vetor.length - 1;
        while (esquerda <= direita) {  // O(log N) iterações
            int meio = esquerda + (direita - esquerda) / 2;
            if (vetor[meio] == elemento) {
                return meio;
            }
            if (vetor[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;  // Elemento não encontrado
    }

    // Algoritmo 4: Merge Sort (O(N log N))
    public static void mergeSort(int[] vetor) {
        if (vetor.length > 1) {
            int meio = vetor.length / 2;
            int[] esquerda = Arrays.copyOfRange(vetor, 0, meio);
            int[] direita = Arrays.copyOfRange(vetor, meio, vetor.length);

            mergeSort(esquerda);  // Recursão
            mergeSort(direita);  // Recursão

            // Combina os subvetores ordenados
            int i = 0, j = 0, k = 0;
            while (i < esquerda.length && j < direita.length) {  // O(N) operações
                if (esquerda[i] < direita[j]) {
                    vetor[k] = esquerda[i];
                    i++;
                } else {
                    vetor[k] = direita[j];
                    j++;
                }
                k++;
            }

            // Copia os elementos restantes
            while (i < esquerda.length) {  // O(N) operações
                vetor[k] = esquerda[i];
                i++;
                k++;
            }
            while (j < direita.length) {  // O(N) operações
                vetor[k] = direita[j];
                j++;
                k++;
            }
        }
    }

    // Função para gerar um vetor de tamanho N
    public static int[] gerarVetor(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = i;  // Vetor ordenado de 0 a N-1
        }
        return vetor;
    }

    // Função principal
    public static void main(String[] args) {
        // Teste Grande (n = 10000, 50000, 100000)
        int[] testeGrande1 = gerarVetor(10000);
        int[] testeGrande2 = gerarVetor(50000);
        int[] testeGrande3 = gerarVetor(100000);

        // Teste Médio (n = 1000, 5000, 10000)
        int[] testeMedio1 = gerarVetor(1000);
        int[] testeMedio2 = gerarVetor(5000);
        int[] testeMedio3 = gerarVetor(10000);

        // Teste Pequeno (n = 100, 500, 1000)
        int[] testePequeno1 = gerarVetor(100);
        int[] testePequeno2 = gerarVetor(500);
        int[] testePequeno3 = gerarVetor(1000);

        // Medição do tempo de execução e contagem de operações
        long inicio, fim;

        // Algoritmo 1: Soma
        System.out.println("=== Algoritmo 1: Soma (O(N)) ===");
        inicio = System.currentTimeMillis();
        soma(testeGrande1);
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=10000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        soma(testeGrande2);
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=50000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        soma(testeGrande3);
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=100000: " + (fim - inicio) + " ms");
        System.out.println();

        // Algoritmo 2: Bubble Sort
        System.out.println("=== Algoritmo 2: Bubble Sort (O(N²)) ===");
        inicio = System.currentTimeMillis();
        bubbleSort(testeGrande1.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=10000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        bubbleSort(testeGrande2.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=50000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        bubbleSort(testeGrande3.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=100000: " + (fim - inicio) + " ms");
        System.out.println();

        // Algoritmo 3: Busca Binária
        System.out.println("=== Algoritmo 3: Busca Binária (O(log N)) ===");
        inicio = System.currentTimeMillis();
        buscaBinaria(testeMedio1, 999);  // Busca pelo último elemento
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=1000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        buscaBinaria(testeMedio2, 4999);  // Busca pelo último elemento
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=5000: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        buscaBinaria(testeMedio3, 9999);  // Busca pelo último elemento
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=10000: " + (fim - inicio) + " ms");
        System.out.println();

        // Algoritmo 4: Merge Sort
        System.out.println("=== Algoritmo 4: Merge Sort (O(N log N)) ===");
        inicio = System.currentTimeMillis();
        mergeSort(testePequeno1.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=100: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        mergeSort(testePequeno2.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=500: " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        mergeSort(testePequeno3.clone());
        fim = System.currentTimeMillis();
        System.out.println("Tempo para N=1000: " + (fim - inicio) + " ms");
    }
}

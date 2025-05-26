import java.util.Scanner;

// Para compilar use: javac src/Main.java
// Para executar use: java -cp src Main < src/"nome do arquivo".txt

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            if (verificaExpressao(linha)) {
                System.out.println("SIM");
            }
            else {
                System.out.println("NAO");
            }
        }
        sc.close();
    }

    public static boolean verificaExpressao(String expressao) {
        Pilha<Character> pilha = new Pilha<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {

                if (pilha.isEmpty()) {
                    return false;
                }

                char topo = pilha.pop();
                if (!combina(topo, c)) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }

    private static boolean combina(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
                (abertura == '[' && fechamento == ']') ||
                (abertura == '{' && fechamento == '}');
    }

    public static final class No<T> {
        private T valor;
        private No<T> proximo;

        public No(T valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public static final class Pilha<T> {
        private No<T> topo;

        public Pilha() {
            this.topo = null;
        }

        public void push(T valor) {
            No<T> novoNo = new No<>(valor);
            novoNo.proximo = topo;
            topo = novoNo;
        }

        public T pop() {
            if (topo == null) {
                throw new RuntimeException("Pilha vazia");
            }
            T valor = topo.valor;
            topo = topo.proximo;
            return valor;
        }

        public boolean isEmpty() {
            return topo == null;
        }
    }
}

package ricardo_paulo.net;

public class Main {
    public static void main (String[] args) {

        System.out.println(toBinary(100));

    }

//    Questão 7
//    Converte um número (Byte, Short, Integer, Long, Float, Double) em binário e retorna uma pilha na qual
//    o topo (peek) é o bit mais significativo e o último elemento é o bit menos significativo. Ou seja, o binário é armazenado
//    na ordem de leitura da esquerda para a direita.
    public static Stack toBinary(Number value) {
        long longValue = value.longValue();
        String binValue = Long.toBinaryString(longValue);
        System.out.println("Binário: " + binValue);
        Stack binaryStack = new Stack();

        for (int i = binValue.length() - 1; i >= 0; i--) {
            binaryStack.push(binValue.charAt(i));
        }

        return binaryStack;
    }

}

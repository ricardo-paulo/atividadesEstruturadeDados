package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;
import ricardo_paulo.net.LinkedList.Node;

public class Main {
    public static void main (String[] args) {
//        RESPOSTAS DAS QUESTÕES TEÓRICAS
//        1 - O primeiro elemento a ser removido é o 11. Após ele o 25 e o 17.
//        Estados da pilha:
//        1ª remoção: [25, 17, 13, 5, 10, 3, 7]
//        2ª remoção: [17, 13, 5, 10, 3, 7]
//        3ª remoção: [13, 5, 10, 3, 7]
//
//        2 - O último elemento a ser removido será o 14 (início da fila).
//        Estados da fila:
//        1ª remoção: [14, 2, 77, 103, 6, 14, 15, 36, 1, 3]
//        2ª remoção: [14, 2, 77, 103, 6, 14, 15, 36, 1]
//        3ª remoção: [14, 2, 77, 103, 6, 14, 15, 36]
//        4ª remoção: [14, 2, 77, 103, 6, 14, 15]
//        5ª remoção: [14, 2, 77, 103, 6, 14]
//
//        NOTA: Apesar de nomes semelhantes às classes 'buildin' do Java, as classes Stack e Queue
//        utilizadas para realizar a atividade são de minha autoria.

        Stack stack = new Stack();
        stack.push(10);
        stack.push(7);
        stack.push(15);
        stack.push(50);
        stack.push(5);
        stack.push(6);

        System.out.println("Pilha original: " + stack);
        System.out.println("Pilha invertida: " + invertStack(stack));

        Stack stack2 = new Stack();
        stack2.push(10);
        stack2.push(7);
        stack2.push(15);
        stack2.push(50);
        stack2.push(5);
        stack2.push(6);

        System.out.println("stack = stack2? " + stack.equals(stack2));

        Stack stack3 = new Stack();
        stack3.push(9);
        stack3.push(9);
        stack3.push(0);
        stack3.push(0);
        stack3.push(9);
        stack3.push(9);

        System.out.println("É um palíndromo? " + isPalindrome(stack3));
    }

//  Questão 3
    public static Stack invertStack(Stack originalStack) {
        Stack invertedStack = new Stack();
        MyLinkedList originalLinkedList = originalStack.getLinkedList();

        Node current = originalLinkedList.getNodeAt(0);
        while (current != null) {
            invertedStack.push(current.element);
            current = current.next;
        }

        return invertedStack;
    }

//    Questão 6
    public static boolean isPalindrome(Stack stack) {
        Stack invertedStack = invertStack(stack);
        return stack.equals(invertedStack);
    }
}

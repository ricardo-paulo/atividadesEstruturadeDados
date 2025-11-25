package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;
import ricardo_paulo.net.LinkedList.Node;

public class Stack {

    private MyLinkedList linkedList;

    public Stack () {
        linkedList = new MyLinkedList();
    }

    public int peek() {
        return linkedList.getNodeAt(0).element;
    }

    public void push(int element) {
        linkedList.addNode(element, 0);
    }

    public int pop() {
        return linkedList.removeNodeAt(0);
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int getLength() {
        return linkedList.getLength();
    }

    public MyLinkedList getLinkedList() {
        return linkedList;
    }

//  Questão 4
    public boolean equals(Stack compared) {
        if (linkedList.getLength() != compared.getLength()) {
            return false;
        }

        boolean isEquals = true;
        MyLinkedList comparedLinkedList = compared.getLinkedList();

        for (int i = 0; i < linkedList.getLength() - 1; i++) {

            Node node1 = linkedList.getNodeAt(i);
            Node node2 = comparedLinkedList.getNodeAt(i);

            if (node1 == null && node2 == null)
                break;

            if (node1 == null || node2 == null || node1.element != node2.element) {
                isEquals = false;
                break;
            };
        }

        return isEquals;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

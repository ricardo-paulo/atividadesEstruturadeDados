package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;
import ricardo_paulo.net.LinkedList.Node;

public class Queue {

    private MyLinkedList linkedList;

    public Queue() {
        linkedList = new MyLinkedList();
    }

    public void enqueue(int element) {
        linkedList.addNode(element, 0);
    }

    public int dequeue() {
        return linkedList.removeNodeAt(linkedList.getLength() - 1);
    }

    public int peek() {
        return linkedList.getNodeAt(linkedList.getLength() - 1).element;
    }

    public int getLength() {
        return linkedList.getLength();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public MyLinkedList getLinkedList() {
        return linkedList;
    }
//  Questão 4
public boolean equals(Queue compared) {
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

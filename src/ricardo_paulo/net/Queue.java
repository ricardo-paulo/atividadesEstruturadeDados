package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;

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

    public boolean equals(Stack compared) {
        boolean isEquals = true;
        MyLinkedList comparedLinkedList = compared.getLinkedList();

        for (int i = 0; i < linkedList.getLength() - 1; i++) {
            if (linkedList.getNodeAt(i).element != comparedLinkedList.getNodeAt(i).element) {
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

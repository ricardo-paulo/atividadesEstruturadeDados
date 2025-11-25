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

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

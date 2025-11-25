package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;

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

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.MyLinkedList;
import ricardo_paulo.net.LinkedList.Client;

public class Queue {

    private MyLinkedList linkedList;

    public Queue() {
        linkedList = new MyLinkedList();
    }

    public void enqueue(String name) {
        linkedList.addNode(name, 0, false);
    }

    public void enqueue(String name, boolean isPriority) {
        linkedList.addNode(name, 0, isPriority);
    }

    public void enqueue(Client newClient) {
        linkedList.addNode(newClient, 0);
        if (linkedList.getLength() > 20)
            linkedList.removeNodeAt(linkedList.getLength() - 1);
    }

    public Client dequeue() {
        return linkedList.removeNodeAt(linkedList.getLength() - 1);
    }

    public String peek() {
        return linkedList.getNodeAt(linkedList.getLength() - 1).name;
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

            Client client1 = linkedList.getNodeAt(i);
            Client client2 = comparedLinkedList.getNodeAt(i);

            if (client1 == null && client2 == null)
                break;

            if (client1 == null || client2 == null || !client1.name.equals(client2.name)) {
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
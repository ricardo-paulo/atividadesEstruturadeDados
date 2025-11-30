package ricardo_paulo.net.LinkedList;

public class MyLinkedList {

    private Client head;
    private int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int getLength () {

        Client current = head;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }

        length = counter;
        return counter;
    }

    public Client getNodeAt (int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Client current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }

        return current;
    }

    public int getNodeIndex (String name) {
        Client current = head;

        for (int j = 0; j < length; j++) {
            if (current != null && current.name.equals(name))
                return j;
        }

        return -1;
    }

    public boolean isEmpty () {
        return getLength() == 0;
    }

    public void addNode (String newName, boolean isPriority) {
        Client newClient = new Client(newName, isPriority);

        if (isEmpty()) {
            head = newClient;
        } else {
            Client lastClient = getNodeAt(length - 1 );
            lastClient.next = newClient;
        }

        length++;
    }

    public void addNode (String newName, int pos, boolean isPriority) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Client newClient = new Client(newName, isPriority);

        if (pos == 0) {
            newClient.next = head;
            head = newClient;
        } else {
            Client previousClient = getNodeAt(pos - 1);
            newClient.next = previousClient.next;
            previousClient.next = newClient;
        }

        length++;
    }

    public void addNode (Client newClient, int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        if (pos == 0) {
            newClient.next = head;
            head = newClient;
        } else {
            Client previousClient = getNodeAt(pos - 1);
            newClient.next = previousClient.next;
            previousClient.next = newClient;
        }

        length++;
    }

    public Client removeNodeAt (int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Client current;
        if (pos == 0) {
            current = head;
            head = head.next;
        } else {
            current = getNodeAt(pos - 1);
            current.next = current.next.next;
        }

        length--;
        return current;
    }

    public boolean contains (String name) {
        Client current = head;

        while (current != null) {
            if (current.name.equals(name))
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder("[");
        Client current = head;

        while (current != null) {
            s.append(current.name);
            if (current.next != null) {
                s.append(",");
            }
            current = current.next;
        }

        s.append("]");
        return s.toString();
    }
}
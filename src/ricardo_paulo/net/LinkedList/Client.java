package ricardo_paulo.net.LinkedList;

import java.time.LocalTime;

public class Client {

    private static long lastId = 0;

    public long id;
    public String name;
    public boolean isPreferential;
    public LocalTime gotInQueue;
    public LocalTime exitedInQueue;
    public Client next;

    public Client(String name, boolean isPreferential) {
        this.id = ++lastId;
        this.name = name;
        this.isPreferential = isPreferential;
        this.gotInQueue = LocalTime.now();
        this.next = null;
    }

    public Client copy() {
        Client clientCopy = new Client(this.name, this.isPreferential);
        clientCopy.id = this.id;
        clientCopy.gotInQueue = this.gotInQueue;
        clientCopy.exitedInQueue = this.exitedInQueue;
        clientCopy.next = null;

        return clientCopy;
    }
}

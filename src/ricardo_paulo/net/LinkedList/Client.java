package ricardo_paulo.net.LinkedList;

import java.time.LocalTime;
import java.util.Random;

public class Client {

    private static final Random random = new Random();
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
}

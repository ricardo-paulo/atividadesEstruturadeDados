package ricardo_paulo.net.LinkedList;

import ricardo_paulo.net.Main;

import java.util.Random;

public class Client {

    private static final Random random = new Random();
    public String name;
    public int responseTime;
    public Client next;

    public Client(String name) {
        this.name = name;
        responseTime = random.nextInt(Main.maxResponseTime);
        this.next = null;
    }
}

package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Main {
    private static Queue commonQueue = new Queue();
    private static Queue preferentialQueue = new Queue();
    private static final Random random = new Random();

//    Utilize as variáveis abaixo para definir tempo máximo de atendimento (segundos) e quantidade máxima de pessoas que
//    podem entrar na fila.
    public static int maxResponseTime = 15;
    public static int maxClientsAmount = 25;

    public static void main (String[] args) throws IOException {
        int clientsAmount = random.nextInt(maxClientsAmount);

        for (int i = clientsAmount; i >= 0; i--) {
            commonQueue.enqueue(genName());
            commonQueue.enqueue(genName());
            preferentialQueue.enqueue(genName());
        }

        System.out.printf("Total de clientes a serem atendidos: %d\n", clientsAmount);
        System.out.printf("Tempo médio de atendimento: %.2f segundo(s)\n\n", normalResponseTime(commonQueue, preferentialQueue));

        for (int a = 0; a <= clientsAmount; a++) {
            if (!commonQueue.isEmpty())
                System.out.println("Cliente atendido: " + commonQueue.dequeue());
            if (!commonQueue.isEmpty())
                System.out.println("Cliente atendido: " + commonQueue.dequeue());
            if (!preferentialQueue.isEmpty())
                System.out.println("Cliente atendido: " + preferentialQueue.dequeue());
        }
    }

    private static String genName() throws IOException {

//        Acessa os nomes dos clientes que serão sorteados. Há 500 nomes completos que serão escolhidos
//        aleatoriamente para ser o nome do novo cliente da fila.
        List<String> clients = Files.lines(Path.of("src/ricardo_paulo/net/data/clients.txt"))
                .toList();

        return clients.get(random.nextInt(clients.size() - 1));
    }

    private static double normalResponseTime(Queue firstQueue, Queue... queues) {
        double queuesSum = 0;
        int queuesLength = 0;
        Client current = firstQueue.getLinkedList().getNodeAt(0);

        for (int i = 0; i < firstQueue.getLength(); i++) {
            queuesSum += current.responseTime;
        }

        for (Queue q : queues) {
            for (int i = 0; i < q.getLength(); i++) {
                queuesSum += current.responseTime;
                queuesLength += q.getLength();
            }
        }

        return queuesSum/(firstQueue.getLength() + queuesLength);
    }
}

package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.Client;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Queue commonQueue = new Queue();
    private static final Queue preferentialQueue = new Queue();
    private static final Random random = new Random();
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private static boolean pauseClientGenScheduler = false;

    // Utilize as constantes abaixo para definir alguns dos parâmetros de execução.
    private static final String CLIENT_NAMES_FILE_PATH = "src/ricardo_paulo/net/data/clients.txt";
    private static final int MAX_CLIENTS = 10;
    private static int MAX_ITERATIONS = 30;
    private static final int MAX_ITERATIONS_INCREASE = 30;

    // Delay para o "atendente" checar as filas e atender o(s) próximo(s) clientes.
    private static final int ATTEND_DELAY = 3;

    // Tempo de pré-agendamento da sub tarefa de criar um cliente.
    private static final int PRE_SCHEDULE_CLIENT_GEN_DELAY = 2;

    // Delay máximo para um novo cliente entrar na fila.
    private static final int CLIENT_GEN_SCHEDULE_MAX_DELAY = 5;

    // Percentual de chance de ser gerado um cliente na fila preferencial: [0 a 99]%.
    public static final int CLIENT_GEN_PREFERENTIAL_CHANCE = 30;

    public static void main (String[] args) {

        // Pré-agendador de geração de clientes.
        scheduler.scheduleWithFixedDelay(Main::scheduleClientGen,
                0, PRE_SCHEDULE_CLIENT_GEN_DELAY, TimeUnit.SECONDS);

        int iterationsCounter = 0;

        while (iterationsCounter < MAX_ITERATIONS) {
            try {
                TimeUnit.SECONDS.sleep(ATTEND_DELAY);
            } catch (InterruptedException e) {
                System.out.println("Execução interrompida!");
            }

            System.out.printf("Antes: %s\n", commonQueue);

            if (!preferentialQueue.isEmpty() && !commonQueue.isEmpty()) {
                attendNextClient(true);
                for (int c = 0; c < 3; c++)
                    if (!commonQueue.isEmpty()) {
                        attendNextClient(false);
                    };
            } else if (!preferentialQueue.isEmpty()) {
                attendNextClient(true);
            } else if (!commonQueue.isEmpty()) {
                attendNextClient(false);
            }

            System.out.printf("Depois: %s\n\n", commonQueue);

            System.out.println("Iterações: " + iterationsCounter);
            iterationsCounter++;

            if (iterationsCounter == MAX_ITERATIONS) {
                pauseClientGenScheduler = true;
                askForContinue();
            }

            pauseClientGenScheduler = false;
        }

        scheduler.shutdown();
    }

    private static Client genClient() throws IOException {

        // Acessa os nomes dos clientes que serão sorteados. Há 500 nomes completos na lista.
        Path clientNamesFile = Path.of(CLIENT_NAMES_FILE_PATH);
        List<String> clients = Files.lines(clientNamesFile).toList();

        String newName = clients.get(random.nextInt(clients.size() - 1));

        // Se o número sorteado (coeficiente de tipo de cliente) estiver, inclusivamente, entre 0 e a chance de gerar
        // um cliente preferencial definida em CLIENT_GEN_PREFERENTIAL_CHANCE, o cliente será preferencial.
        // Caso contrário, o cliente a ser gerado entrará na fila comum.
        int clientTypeCoefficient = random.nextInt(0, 100);
        boolean isPreferential = clientTypeCoefficient < CLIENT_GEN_PREFERENTIAL_CHANCE;

        return new Client(newName, isPreferential);
    }

    // Agendador de geração e entrada do cliente na fila.
    private static void scheduleClientGen() {
        if (!pauseClientGenScheduler) {
            int delay = random.nextInt(1, CLIENT_GEN_SCHEDULE_MAX_DELAY + 1);

            scheduler.schedule(() -> {
                if ((commonQueue.getLength() + preferentialQueue.getLength()) < MAX_CLIENTS) {
                    try {
                        Client newClient = genClient();
                        if (newClient.isPreferential) {
                            preferentialQueue.enqueue(newClient);
                        } else {
                            commonQueue.enqueue(newClient);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, delay, TimeUnit.SECONDS);
        }
    }

    private static void attendNextClient(boolean isPreferential) {
        Client current;
        if (isPreferential) {
            current = preferentialQueue.dequeue();
        } else {
            current = commonQueue.dequeue();
        }
        current.exitedInQueue = LocalTime.now();
    }

    private static void askForContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gostaria de continuar com a execução? (true ou false) ");
        boolean continueExecution = scanner.nextBoolean();

        if (continueExecution) {
            MAX_ITERATIONS += MAX_ITERATIONS_INCREASE;
        }
    }
}

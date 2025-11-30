package ricardo_paulo.net;

import ricardo_paulo.net.LinkedList.Client;
import ricardo_paulo.net.LinkedList.MyLinkedList;

import java.text.DecimalFormat;
import java.time.Duration;

public class PerformanceMetrics {

    private final Queue finishedCommonQueue;
    private final Queue finishedPreferentialQueue;
    private final Queue commonQueue;
    private final Queue prioritaryQueue;

    public PerformanceMetrics(Queue commonQueue, Queue preferentialQueue) {
        this.finishedCommonQueue = new Queue();
        this.finishedPreferentialQueue = new Queue();
        this.commonQueue = commonQueue;
        this.prioritaryQueue = preferentialQueue;
    }

    public void addFinishedService(Client client) {
        if (client.isPreferential) {
            finishedPreferentialQueue.enqueue(client);
        } else {
            finishedCommonQueue.enqueue(client);
        }
    }

    public int getNumberServicesFinished() {
        return finishedCommonQueue.getLength() + finishedPreferentialQueue.getLength();
    }

    @Override
    public String toString() {

        // 1ª MÉTRICA - Atendimentos restantes nas filas.
        StringBuilder stringBuilder = new StringBuilder("MÉTRICAS DE DESEMPENHO\n");
        stringBuilder.append("Fila prioritária: ").append(prioritaryQueue).append('\n');
        stringBuilder.append("Fila comum: ").append(commonQueue).append('\n');

        // 2ª MÉTRICA - Tempo de atendimento individual.
        stringBuilder.append("Tempo de atendimento individual: ").append('\n');
        MyLinkedList finishedCommonServicesList = finishedCommonQueue.getLinkedList();
        MyLinkedList finishedPreferentialServicesList = finishedPreferentialQueue.getLinkedList();

        Client preferentialCurrent = finishedPreferentialServicesList.getNodeAt(0);
        Client commonCurrent = finishedCommonServicesList.getNodeAt(0);
        double commonServiceSum = 0;
        double preferentialServiceSum = 0;

        for (int c = 0; c < finishedPreferentialServicesList.getLength() + finishedCommonServicesList.getLength(); c++) {
            if (preferentialCurrent != null) {
                Duration duration = Duration.between(preferentialCurrent.gotInQueue, preferentialCurrent.exitedInQueue);
                long secondsOfDuration = duration.toSeconds();
                preferentialServiceSum += secondsOfDuration;

                stringBuilder.append(preferentialCurrent.name)
                        .append(" - ")
                        .append(secondsOfDuration)
                        .append(" segundo(s)\n");

                preferentialCurrent = preferentialCurrent.next;
                continue;
            }

            if (commonCurrent != null) {
                Duration duration = Duration.between(commonCurrent.gotInQueue, commonCurrent.exitedInQueue);
                long secondsOfDuration = duration.toSeconds();
                commonServiceSum += secondsOfDuration;

                stringBuilder.append(commonCurrent.name)
                        .append(" -> ")
                        .append(secondsOfDuration)
                        .append(" segundo(s)\n");

                commonCurrent = commonCurrent.next;
            }
        }

        // 3ª, 4ª E 5ª MÉTRICA - Tempo de atendimento médio por fila e geral.
        double commonServiceNormal = commonServiceSum / finishedCommonServicesList.getLength();
        double preferentialServiceNormal = preferentialServiceSum / finishedPreferentialServicesList.getLength();
        DecimalFormat formatter = new DecimalFormat(".##");

        stringBuilder.append("\nTempo médio de atendimento da fila comum: ")
                .append(formatter.format(commonServiceNormal))
                .append(" segundo(s)\n");

        stringBuilder.append("Tempo médio de atendimento da fila preferencial: ")
                .append(formatter.format(preferentialServiceNormal))
                .append(" segundo(s)\n");

        stringBuilder.append("Tempo de atendimento médio geral: ")
                .append(formatter.format(commonServiceNormal + preferentialServiceNormal))
                .append(" segundo(s)");

        return stringBuilder.toString();
    }
}
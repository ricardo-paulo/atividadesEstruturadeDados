public class Question1 {
    public static void main(String[] args) {
        int[] V = {10, 13, 5, 47, 36, 17, 25, 1, 30};
        int target = 25;
        int i = 0;

        while (i < V.length) {
            if (V[i] == target) {
                System.out.printf("Complexidade algorítmica = %d\n", i + 1);
                break;
            }
            i++;
        }
    }
}

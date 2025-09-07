public class Question2 {

    private static final double[] numbs = {0.25, 2.48, 345.47, 154.17, 46.01};

    public static void main(String[] args) {
        double target = 154.17;
        System.out.println(searchTarget(target));
    }

    private static int searchTarget(double target) {
        int i = 0;

        while (i < numbs.length) {
            if(numbs[i] == target) {
                return i;
            }
            i++;
        }

        return -1;
    }
}

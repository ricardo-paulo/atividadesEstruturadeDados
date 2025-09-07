public class Question3 {

    private static final int[] numbs = {25, 2, 345, 154, 46, 154, 2, 2, 2};

    public static void main(String[] args){
        int target = 2;
        System.out.println(searchTarget(target));
    }

    private static int searchTarget(int target) {
        int i = 0;
        int repeats = 0;

        while (i < numbs.length) {
            if(numbs[i] == target) {
                repeats++;
            }
            i++;
        }

        return repeats;
    }
}

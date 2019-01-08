
public class Sequence {

    private static int efficiency = 0;

    //Iterative method
    public static int computeIterative(int n) {
        int termA = 0;
        int termB = 1;
        efficiency = 0;
        if (n <= 0) {
            return termA;
        } else if (n == 1) {
            return termB;
        } else {
            for (int i = 0; i < (n - 1); ++i) {
                ++efficiency;
                int aux = termA + 2 * termB;
                termA = termB;
                termB = aux;
            }
            return termB;
        }
    }

    //Recursive method
    public static int computeRecursive(int n) {
        efficiency = 0;
        int termA = 0;
        int termB = 1;
        return calculate(n, termA, termB);
    }

    public static int calculate(int n, int termA, int termB) {
        if (n <= 0) {
            return termA;
        } else if (n == 1) {
            return termB;
        } else {
            ++efficiency;
            int aux = termA + 2 * termB;
            termA = termB;
            termB = aux;
            --n;
            return calculate(n, termA, termB);
        }
    }

    public static int getEfficiency() {
        return Sequence.efficiency;
    }

}


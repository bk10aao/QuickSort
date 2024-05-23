import edu.princeton.cs.introcs.StdRandom;

@SuppressWarnings({"unchecked", "rawtypes"})
public class QuickSort {

    public static void sort(Comparable[] values) {
        StdRandom.shuffle(values);
        sort(values, 0, values.length - 1);
    }

    private static void sort(Comparable[] values, int low, int high) {
        if(high <= low) return;
        int j = partition(values, low, high);
        sort(values, low, j - 1);
        sort(values, j + 1, high);
    }

    private static int partition(Comparable[] values, int low, int high) {
        int leftPointer = low;
        int rightPointer = high + 1;
        while (true) {
            while(less(values[++leftPointer], values[low]))
                if (leftPointer == high) break;
            while(less(values[low], values[--rightPointer]))
                if (rightPointer == low) break;
            if(leftPointer >= rightPointer) break;
            exchange(values, leftPointer, rightPointer);
        }
        exchange(values, low, rightPointer);
        return rightPointer;
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private static void exchange(Comparable[] c, int i, int j) {
        Comparable swap = c[i];
        c[i] = c[j];
        c[j] = swap;
    }
}

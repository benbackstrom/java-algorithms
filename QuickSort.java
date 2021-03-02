public class QuickSort {

    public static void main(String[] args) {
        {
            int[] test = new int[] { 2, 1 };
            System.out.println("Sort 2, 1:");
            quickSort(test);
            for (int num : test)
                System.out.print(" "+num);

            System.out.println();
            System.out.println();
        }

        {
            int[] test = new int[] { 5, 1, 4, 2, 3 };
            System.out.println("Sort 5, 1, 4, 2, 3:");
            quickSort(test);
            for (int num : test)
                System.out.print(" "+num);

            System.out.println();
            System.out.println();
        }
        
        {
            int[] test = new int[] { 1, 2, 3, 4 };
            System.out.println("Sort 1, 2, 3, 4:");
            quickSort(test);
            for (int num : test)
                System.out.print(" "+num);

            System.out.println();
            System.out.println();
        }
        
        {
            int[] test = new int[] { 4, 3, 2, 1 };
            System.out.println("Sort 4, 3, 2, 1:");
            quickSort(test);
            for (int num : test)
                System.out.print(" "+num);

            System.out.println();
            System.out.println();
        }
    }
    
    public static void quickSort(int[] input) {
        if (input == null || input.length < 2)
            return;

        quickSort(input, 0, input.length - 1);
    }

    private static void quickSort(int[] input, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = partition(input, lo, hi);
        quickSort(input, 0, mid-1);
        quickSort(input, mid+1, hi);
    }

    private static int partition(int[] input, int lo, int hi) {
        // Pick the partition value
        int mid = lo + (hi - lo) / 2;
        int midVal = input[mid];
        
        // Put partition value at the end, out of the way
        swap(input, mid, hi);

        int i = lo - 1;
        for (int j=lo; j<=hi-1; j++) {
            int jVal = input[j];
            if (jVal < midVal) {
                i++;
                swap(input, j, i);
            }
        }

        i++;
        swap(input, i, hi);

        return i;
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}

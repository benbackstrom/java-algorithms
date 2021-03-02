class BinarySearch {
    
    public static void main(String[] args) {
        int[] test1 = new int[] { 1 };
        System.out.println("1 in 1: "+binarySearch(test1, 1));
        System.out.println("2 in 1: "+binarySearch(test1, 2));

        int[] test2 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("1 in 1, 2, 3, 4, 5: "+binarySearch(test2, 1));
        System.out.println("2 in 1, 2, 3, 4, 5: "+binarySearch(test2, 2));
        System.out.println("3 in 1, 2, 3, 4, 5: "+binarySearch(test2, 3));
        System.out.println("4 in 1, 2, 3, 4, 5: "+binarySearch(test2, 4));
        System.out.println("5 in 1, 2, 3, 4, 5: "+binarySearch(test2, 5));
        System.out.println("6 in 1, 2, 3, 4, 5: "+binarySearch(test2, 6));

        int[] test3 = new int[] { 1, 2, 3, 4 };
        System.out.println("3 in 1, 2, 3, 4: "+binarySearch(test3, 3));
    }

    public static int binarySearch(int[] sortedInput, int findMe) {
        if (sortedInput == null)
            return -1;
        
        return binarySearch(sortedInput, findMe, 0, sortedInput.length - 1);
    }

    public static int binarySearch(int[] sortedInput, int findMe, int lo, int hi) {
        if (lo == hi && sortedInput[lo] != findMe) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        int midValue = sortedInput[mid];

        if (midValue > findMe) {
            return binarySearch(sortedInput, findMe, lo, mid);
        } else if (midValue < findMe) {
            return binarySearch(sortedInput, findMe, mid+1, hi);
        } else {
            return mid;
        }
    }
}
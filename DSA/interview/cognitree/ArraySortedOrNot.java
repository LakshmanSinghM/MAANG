package interview.cognitree;

public class ArraySortedOrNot {

    // the interview followed up to this level

    static void checkSortedOptimized(int[] arr) {

        if (arr.length <= 1) {
            System.out.println("Sorted (Single Element)");
            return;
        }

        int i = 1;

        // Skip duplicates
        while (i < arr.length && arr[i] == arr[i - 1]) {
            i++;
        }

        // All elements are equal
        if (i == arr.length) {
            System.out.println("Sorted in Ascending Order");
            return;
        }

        //Decide direction
        boolean ascending = arr[i] > arr[i - 1];

        // Validate rest
        for (; i < arr.length; i++) {

            if (ascending && arr[i] < arr[i - 1]) {
                System.out.println("Not Sorted");
                return;
            }

            if (!ascending && arr[i] > arr[i - 1]) {
                System.out.println("Not Sorted");
                return;
            }
        }

        System.out.println(ascending ? "Sorted in Ascending Order" : "Sorted in Descending Order");
    }

    public static void main(String[] args) {
        // array is sorted or not and if it is give the order asc, desc
        // 1 1 2 2 3 3
        // 1 1 1 1 1 1
        // 1
        // 1 2 3 3 3
        // 3 2 1
        // 3 0 1
    }

    // my solution was
    static void checkSorted(int[] arr) {

        if (arr.length <= 1) {
            System.out.println("Sorted (Single Element)");
            return;
        }

        boolean isAsc = true;
        boolean isDesc = true;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {
                isAsc = false;
            }

            if (arr[i] > arr[i - 1]) {
                isDesc = false;
            }
        }

        if (isAsc) {
            System.out.println("Sorted in Ascending Order");
        } else if (isDesc) {
            System.out.println("Sorted in Descending Order");
        } else {
            System.out.println("Not Sorted");
        }
    }
}

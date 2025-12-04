// https://takeuforward.org/plus/dsa/problems/find-row-with-maximum-1's

public class FindMaxOnesInRows {
    private static int findLowerBoundOfOneWithMax(int arr[]) {
        // 0 0 0 1 1 1
        int ele = 1, low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (ele <= arr[mid]) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans != -1 ? (arr.length - ans) : -1;
    }

    private static int rowNumOfTheMaxOne(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int val = findLowerBoundOfOneWithMax(arr[i]);

            if (val != -1 && max < val) {
                index = i;
                max = val;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][] {
                { 0, 0, 0, 0 },
                // { 0, 1, 1, 1 },
                // { 1, 1, 1, 1 },
                // { 0, 0, 0, 1 },
                // { 0, 0, 0, 0 }
        };
        System.out.println("Max ones row " + rowNumOfTheMaxOne(arr));
    }
}
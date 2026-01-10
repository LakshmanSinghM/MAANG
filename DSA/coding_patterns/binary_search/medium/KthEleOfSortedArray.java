// https://takeuforward.org/plus/dsa/problems/kth-element-of-2-sorted-arrays

public class KthEleOfSortedArray {

    public static int withoutUsingArray(int arr[], int arr1[], int k) {
        int ele1 = -1;
        int i = 0, j = 0, cnt = 0;

        while (i < arr.length && j < arr1.length) {
            if (arr[i] <= arr1[j]) {
                cnt++;
                if (cnt == k)
                    ele1 = arr[i];
                i++;

            } else {
                cnt++;
                if (cnt == k)
                    ele1 = arr1[j];
                j++;

            }
        }

        while (i < arr.length) {
            cnt++;
            if (cnt == k)
                ele1 = arr[i];
            i++;
        }

        while (j < arr1.length) {
            cnt++;
            if (cnt == k)
                ele1 = arr1[j];
            j++;
        }
        System.out.println("CNT is " + cnt + "   ele1 " + ele1);

        return ele1;
    }

    public static int kthElement(int[] a, int[] b, int k) {
        return withoutUsingArray(a, b, k);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int arr1[] = { 3, 4, 5 };
        int k = 4;
        System.out.println(kthElement(arr, arr1, k));
    }
}

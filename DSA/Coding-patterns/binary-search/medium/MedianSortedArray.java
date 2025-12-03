// https://leetcode.com/problems/median-of-two-sorted-arrays

public class MedianSortedArray {

    public static double withoutUsingArray(int arr[], int arr1[]) {
        int len = (arr.length + arr1.length);
        int mid = len / 2, cnt = 0;
        double ele1 = -1, ele2 = -1;
        int mid_less = mid - 1, i = 0, j = 0;

        while (i < arr.length && j < arr1.length) {
            if (arr[i] <= arr1[j]) {
                cnt++;
                if (cnt == mid_less)
                    ele1 = arr[i];
                if (cnt == mid)
                    ele2 = arr[i];
                i++;

            } else {
                cnt++;
                if (cnt == mid_less)
                    ele1 = arr[i];
                if (cnt == mid)
                    ele2 = arr[i];
                j++;
            }
        }

        while (i < arr.length) {
            cnt++;
            if (cnt == mid_less)
                ele1 = arr[i];
            if (cnt == mid)
                ele2 = arr[i];

            i++;
        }

        while (j < arr1.length) {
            cnt++;
            if (cnt == mid_less)
                ele1 = arr[i];
            if (cnt == mid)
                ele2 = arr[i];
            j++;
        }

        if (len % 2 == 0) {
            return (ele1 + ele2) / 2;
        }
        return ele2;
    }

    public static double withUsingArray(int arr[], int arr1[]) {
        int arr3[] = new int[arr.length + arr1.length];
        int k = 0;
        int i = 0, j = 0;

        while (i < arr.length && j < arr1.length) {
            if (arr[i] <= arr1[j])
                arr3[k++] = arr[i++];
            else
                arr3[k++] = arr1[j++];
        }

        while (i < arr.length)
            arr3[k++] = arr[i++];
        while (j < arr1.length)
            arr3[k++] = arr1[j++];

        int mid = arr3.length / 2;
        if (arr3.length % 2 == 0) {
            double ele1 = arr3[mid - 1];
            double ele2 = arr3[mid];
            return (ele1 + ele2) / 2;
        }
        return arr3[mid];
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return withUsingArray(nums1, nums2);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4 };
        int arr1[] = { 1, 2, 3, 4 };

        System.out.println(findMedianSortedArrays(arr, arr1));
    }
}

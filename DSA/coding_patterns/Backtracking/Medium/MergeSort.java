package medium;

import java.util.*;

public class MergeSort {

  public static void divideOrsort(int arr[], int s, int e) {
    if (s == e)
      return;
    int m = (s + e) / 2;
    divideOrsort(arr, s, m);
    divideOrsort(arr, m + 1, e);
    merge(arr, s, m, e);
  }

  public static void merge(int arr[], int s, int m, int e) {
    int arr1[] = new int[e - s + 1];
    int k = 0, l = s, r = m + 1;

    while (l <= m && r <= e) {
      if (arr[l] <= arr[r]) {
        arr1[k++] = arr[l++];
      } else {
        arr1[k++] = arr[r++];
      }
    }
    while (l <= m) {
      arr1[k++] = arr[l++];
    }
    while (r <= e) {
      arr1[k++] = arr[r++];
    }
    for (int j = 0; j < arr1.length; j++)
      arr[s + j] = arr1[j];
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 1, 3, 4, 6, 0 };
    divideOrsort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}

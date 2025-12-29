package medium;

import java.util.*;

public class QuickSort {
  // 1 6 7 8 9 2 3 0 5
  // 1 0 7 8 9 2 3 6 5

  public static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int partition(int arr[], int low, int high) {

    // { 1, 2, 0, 5, 4 }
    // { 4, 2, 0, 5, 1 }

    int s = low;
    int e = high - 1;
    int pivot = arr[low];

    while (s < e) {
      while (arr[s] <= pivot && s <= high - 1)
        s++;
      while (arr[e] > pivot && e >= low + 1)
        e--;
      if (s < e)
        swap(arr, s, e);
    }
    swap(arr, e, low);
    return e;
  }

  public static void quickSort(int arr[], int s, int e) {
    if (s < e) {
      int p = partition(arr, s, e);
      quickSort(arr, s, p - 1);
      quickSort(arr, p + 1, e);
    }
  }

  public static void main(String[] a) {
    int arr[] = new int[] { 1, 2, 4, 5, 4 };
    quickSort(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));
  }
}
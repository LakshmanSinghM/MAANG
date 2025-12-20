import java.util.Arrays;

public class QuickSort {

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i]<=pivot && i <= high - 1) {
                i++;
            }
            while (pivot < arr[j] && j >= low + 1) {
                j--;
            }
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void quickSort(int arr[], int low, int high) {
        System.out.println("FInfodshf");
        if (low < high) {
            int partion = partition(arr, low, high);
            quickSort(arr, low, partion - 1);
            quickSort(arr, partion + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 3, 5, 1, 0, 4 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

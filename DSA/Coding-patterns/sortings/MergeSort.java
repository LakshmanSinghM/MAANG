import java.util.Arrays;

public class MergeSort {

    static void merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        // 1 1 2 3
        // 0 1 3
        while (left <= mid && right<=high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right<=high) {
            temp[k++] = arr[right++];
        }
        
        System.out.println(Arrays.toString(arr));
        //  1 2 3 
        //     low
        //     4 5
        for(int i=0; i<temp.length; i++){
            arr[low+i] = temp[i];
        }
    }

    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 5, 2, 0 };
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

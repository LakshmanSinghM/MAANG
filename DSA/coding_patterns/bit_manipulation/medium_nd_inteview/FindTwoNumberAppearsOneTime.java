// https://takeuforward.org/plus/dsa/problems/single-number---iii

package coding_patterns.bit_manipulation.medium_nd_inteview;

import java.util.Arrays;

public class FindTwoNumberAppearsOneTime {

    int[] findTwoNumberAppearsOneTime(int arr[]) {

        long XOR = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR = XOR ^ arr[i];
        }

        long rigthMost = (XOR & (XOR - 1)) ^ XOR;

        int b1 = 0, b2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if ((rigthMost & arr[i]) == 0) {
                b1 = b1 ^ arr[i];
            } else
                b2 = b2 ^ arr[i];
        }
        if (b1 < b2)
            return new int[] { b1, b2 };

        return new int[] { b2, b1 };
    }

    public static void main(String[] args) {
        FindTwoNumberAppearsOneTime findTwoNumberAppearsOneTime = new FindTwoNumberAppearsOneTime();
        int arr[] = { 1, 1, 2, 2, 3, 5 };
        System.out.println(Arrays.toString(findTwoNumberAppearsOneTime.findTwoNumberAppearsOneTime(arr)));
    }
}

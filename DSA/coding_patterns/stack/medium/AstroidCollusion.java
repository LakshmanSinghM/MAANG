// https://leetcode.com/problems/asteroid-collision/

package coding_patterns.stack.medium;

import java.util.LinkedList;
import java.util.List;

public class AstroidCollusion {

    public int[] asteroidCollision(int[] arr) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isBroken = false;

            while (!list.isEmpty() && arr[i] < 0 && list.getLast() > 0) {

                if (Math.abs(arr[i]) == Math.abs(list.getLast())) {
                    list.removeLast();
                    isBroken = true;
                    break;
                } else if (Math.abs(list.getLast()) < Math.abs(arr[i]))
                    list.removeLast();
                else {
                    isBroken = true;
                    break;
                }
            }
            if (!isBroken)
                list.add(arr[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}

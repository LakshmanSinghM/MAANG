// https://leetcode.com/problems/combination-sum-iii/description/

package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    void listAllComboOfKSizeWithKSum(List<List<Integer>> lists, int start, int n, int k, int target,
            List<Integer> list) {
                
        if (target < 0 || start >= n)
            return;

        if (list.size() == k && target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int index = start; index <=n; index++) {
            list.add(index);
            listAllComboOfKSizeWithKSum(lists, index + 1, n, k, target - index, list);
            list.removeLast(); 
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int k = 3;
        int target = 10;
        new CombinationSumIII().listAllComboOfKSizeWithKSum(lists, 1, 9, k, target, new ArrayList<>());
        System.out.println(lists);
    }
}
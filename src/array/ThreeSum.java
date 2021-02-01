package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum
 * Use three pointers:
 * - iterate through the list
 * - fix start = i+1, end = n-1, then move start and end according to the sum
 *
 * one tricky thing about this question is to remove duplicate:
 * - check if nums[i] == nums[i-1] and skip
 * - when sum=0, keep increment start if nums[start] == nums[start-1]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {

            //skip duplicate i
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> newResult = new ArrayList<>();

                    /*Collections.sort(newResult);
                    if (!result.contains(newResult)) {
                        result.add(newResult);
                    }*/
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //skip duplicate start
                    while (start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}

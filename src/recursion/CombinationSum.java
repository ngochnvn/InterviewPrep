package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 * use a trick to avoid duplicates:
 * - iterate through the nums and recursively
 * - use a list to keep track of path so far.
 * - Pass in result so we can add to result when remaining is 0
 *
 * //example: [2,3,6,7], 7
 *
 * [], [2,3,6,7], 7
 * -> [2], [2,3,6,7], 5
 *   -> [2,2], [2,3,6,7], 3
 *     -> [2,2,2], [2,3,6,7], 1
 *       -> [2,2,2,2], [2,3,6,7], -1 => return
 *       -> [2,2,2,3], [3,6,7], -2 => return
 *       -> [2,2,2,6], [6,7], -5 => return
 *       -> [2,2,2,7], [7], -6 => return
 *     -> [2,2,3], [3,6,7], 0 => add [2,2,3]
 *     -> [2,2,6], [6,7], -3 => return
 *     -> [2,2,6], [7], -4 => return
 *   -> [2,3], [3,6,7], 2
 *     -> [2,3,3], [3,6,7], -1 => return
 *     -> [2,3,6], [6,7], -4 => return
 *     -> [2,3,7], [7], -5 => return
 *   -> [2,6], [6,7], -1 => return
 *   -> [2,7], [7], -2 => return
 * -> [3], ...
 *
 *
 **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public void backTrack(List<List<Integer>> solutions, List<Integer> current, int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            solutions.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backTrack(solutions, current, candidates, i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(Math.abs(Integer.MAX_VALUE + 1));
    }

}

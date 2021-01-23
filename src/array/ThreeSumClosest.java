package array;

/**
 * https://leetcode.com/problems/3sum-closest/
 * We can't use HashMap since we need to find the closest.
 * HashMap only works if we find value that matches exactly
 * Common approach here is to:
 * - sort the array
 * - iterate through each values (fix one value,
 * then use two pointer to find the best solution with the fixed value)
 *   - use two pointers to optimize for the best value.
 *   we can determine the direction because the array is sorted.
 *
 * that way, for each element, we find the best solution that includes that element,
 * thus guarantee to find the best solution for the problem
 */
public class ThreeSumClosest {
}

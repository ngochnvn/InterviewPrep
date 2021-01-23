package string;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close
 *
 * From the questions we can deduce that:
 * - two strings have same unique set of character
 * - two strings have same set of frequency for characters: eg: [a: 5, c:4], [a:4, c:5]
 *
 * Solution:
 * - map with character count
 * - compare keySet (Set can be compared using equals)
 * - compare the values collection. Since there are only limited number of character,
 * 26 for lower case, it's OK to use Arrays.sort(count.values())
 */
public class CloseStrings {
}

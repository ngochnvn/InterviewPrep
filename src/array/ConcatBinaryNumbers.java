package array;

/**

 go through each num, convert to binary. For each i in binary, sum = sum * 2 + i.

 N=3
 sum = 0
 1 -> 1 -> sum * 2 + 1 = 1
 2 -> 10 -> sum * 2 + 1 -> 3 * 2 + 0 -> 6
 3 -> 11 -> sum * 2 + 1 -> 13 * 2 + 1 -> 27
 4 -> 100 -> 27 * 2 + 1 -> 55 * 2 -> 110 * 2 = 220

 */

public class ConcatBinaryNumbers {
    public int concatenatedBinary(int n) {
        int mod = (int) Math.pow(10, 9) + 7;
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (char c: binary.toCharArray()) {
                int num = c == '0' ? 0 : 1;
                sum = (sum * 2 + num) % mod;
            }
        }
        return (int) sum;
    }
}
package dp;

/**
 * list out example and use DP. T(N) = T(N - 1) * SUM(1 to 2N-1).
 * This is because those are the number of position to put the new Pn and Dn.
 *
 * Only need to keep previous answer to optimize for O(1) space
 */
class PickUpDeliveryOptions {
    public int countOrders(int n) {
        long[] result = new long[n+1];
        result[0] = 0;
        result[1] = 1;

        long answer = 1;

        for (int i = 2; i <= n; i++) {
            answer = answer * i * (2 * i - 1);
            if (answer > Integer.MAX_VALUE) {
                answer = new Double(answer % (Math.pow(10, 9) + 7)).longValue();
            }
        }
        return new Long(answer).intValue();
    }
}
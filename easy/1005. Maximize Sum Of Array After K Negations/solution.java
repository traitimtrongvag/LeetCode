class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] numbers = new int[201];
        int sum = 0;
        int maxAbs = 0;
        for (int n: nums) {
            maxAbs = Math.max(maxAbs, Math.abs(n));
            numbers[100 + n]++;
            sum += n;
        }
        if (maxAbs == 0) {
            return 0;
        }
        while (k-- != 0) {
            int i = 100 - maxAbs;
            while (numbers[i] == 0) {
                i++;
            }
            numbers[i]--;
            numbers[200 - i]++;
            sum -= 2 * (i - 100);
        }
        return sum;
    }
}
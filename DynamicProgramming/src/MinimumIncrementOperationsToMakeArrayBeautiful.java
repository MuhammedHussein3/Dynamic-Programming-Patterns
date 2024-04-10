import java.util.Arrays;

public class MinimumIncrementOperationsToMakeArrayBeautiful {
    class Solution {
        public long minIncrementOperations(int[] nums, int k) {

            dp = new long[nums.length];
            Arrays.fill(dp,-1);
            return solve(0,nums,k);
        }

        long[] dp;
        long solve(int i,int[] nums, int k) {
            if (i+2>=nums.length) {
                return 0;
            }
            if (dp[i]!=-1) return dp[i];
            long res = (long)1e18;
            for (int s = 1;s<=3;s++) {
                long op = Math.max(0, k - nums[i+(s-1)]) + solve(i + s, nums, k);
                res = Math.min(res,op);
            }
            return dp[i] = res;

        }
    }
}

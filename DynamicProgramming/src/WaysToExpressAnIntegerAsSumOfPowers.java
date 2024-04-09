import java.util.ArrayList;
import java.util.Arrays;

public class WaysToExpressAnIntegerAsSumOfPowers {
    class Solution {
        public static int mod = 1000000007;
        public int numberOfWays(int n, int x) {

            ArrayList<Integer> ans = new ArrayList<Integer>();
            for(int i = 1; i <= n ; i++)
            {
                int temp = (int)Math.pow(i,x);
                if(temp <= n)
                    ans.add(temp);
                else
                    break;
            }
            dp = new int[ans.size()][n+1];
            for (int[]row: dp) Arrays.fill(row, -1);
            return solve(0,n,ans);
        }
        int dp[][];
        int solve(int i,int sum ,ArrayList<Integer> arr)
        {


            if (sum<=0)
                return sum==0?1:0;
            if(i>=arr.size())
                return 0;
            if (dp[i][sum]!=-1)
                return dp[i][sum];
            int take = 0;
            if(sum-arr.get(i)>=0)
                take = solve(i+1,sum-arr.get(i),arr)%mod;
            int leave = solve(i+1,sum,arr)%mod;
            return dp[i][sum] = (take+leave)%mod;
        }
    }
}

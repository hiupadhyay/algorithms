package practise.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {


    static int coinChangeDp(int coins[], int amount) {
        //dp denontes min element required to make a sum
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //denomination
            int coinDenomination = coins[i];
            for (int j = coinDenomination; j < dp.length; j++) {
                //basically min of existing sum and previous sum
                dp[j] = Math.min(dp[j], dp[j - coinDenomination] + 1);
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    static int coinChange(int[] deno, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();
        return coinChange(deno, sum, cache);
    }


    static int coinChange(int[] deno, int sum, Map<Integer, Integer> cache) {
        if (sum < 0) return -1;
        if (sum == 0) return 0;
        if (cache.containsKey(sum))
            return cache.get(sum);
        int fewestNoOfCoin = -1;
        for (int i = 0; i < deno.length; i++) {
            int sumFromLeaf = coinChange(deno, sum - deno[i]);
            if (sumFromLeaf >= 0)
                fewestNoOfCoin = fewestNoOfCoin < 0 ? sumFromLeaf + 1 : Math.min(fewestNoOfCoin, sumFromLeaf + 1);

        }
        cache.put(sum, fewestNoOfCoin);
        return fewestNoOfCoin;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}

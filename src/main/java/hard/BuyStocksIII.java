package hard;

public class BuyStocksIII {

    public int maxProfit(int[] prices) {

        int[] left = new int[prices.length];
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            left[i] = maxProfit;
        }

        int[] right = new int[prices.length];
        int maxPrice = Integer.MIN_VALUE;
        maxProfit = Integer.MIN_VALUE;

        int max = 0;

        for (int j = prices.length - 1; j >= 0; j--) {
            maxPrice = Math.max(maxPrice, prices[j]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[j]);
            right[j] = maxProfit;
        }

        for (int k = 0; k < right.length; k++) {
            max = Math.max(max, left[k] + right[k]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        BuyStocksIII buyStocksIII = new BuyStocksIII();
        System.out.println(buyStocksIII.maxProfit(prices));

    }
}

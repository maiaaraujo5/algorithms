import java.util.LinkedList;

public class ProfitStock {
    public static void main(String[] args) {
        int[] stocksPrice = new int[]{10, 9, 8, 8, 7, 6, 2, 10};
        int result = getMaxProfit(stocksPrice);
        System.out.println(result);
    }

    public static int getMaxProfit(int[] stockPrices) {
        int lowerPrice = stockPrices[0];
        int higherPrice = 0;

        for (int stockPrice : stockPrices) {
            if (stockPrice < lowerPrice) {
                lowerPrice = stockPrice;
                higherPrice = 0;
            } else if (stockPrice > higherPrice) {
                higherPrice = stockPrice;
            }
        }

        return higherPrice - lowerPrice;
    }
}
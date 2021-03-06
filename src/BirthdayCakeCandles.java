import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        List<Integer> candles = new ArrayList<>(Arrays.asList(4,4,4,1,3));
        int howManyTimesTallestAppears = birthdayCakeCandles(candles);
        System.out.println(howManyTimesTallestAppears);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        candles.sort(Comparator.naturalOrder());
        int tallest = candles.get(candles.size() - 1);
        int howManyTimesTallestAppears = 0;

        for (Integer candle : candles) {
            if (candle == tallest) {
                howManyTimesTallestAppears++;
            }
        }
        return howManyTimesTallestAppears;
    }
}

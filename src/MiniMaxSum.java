import java.util.Arrays;
import java.util.stream.IntStream;

public class MiniMaxSum {
    public static void main(String[] args) {
        int[] nums = new int[]{256741038, 623958417, 467905213, 714532089, 938071625};
        miniMaxSum(nums);
    }

    public static void miniMaxSum(int[] arr) {
        long maxSum = 0;
        long minSum = 0;

        IntStream sorted = Arrays.stream(arr).sorted();
        arr = sorted.toArray();

        for (int i = 1; i < arr.length; i++) {
            maxSum += arr[i];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            minSum += arr[i];
        }

        System.out.printf("%d %d", minSum, maxSum);
    }
}

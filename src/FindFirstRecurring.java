import java.util.HashMap;
import java.util.HashSet;

public class FindFirstRecurring {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 5, 2, 3, 5, 1, 2, 4};
        int find = findFirstRecurring(array);
        System.out.println(find);
    }

    public static int findFirstRecurring(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int number : numbers) {
            if (hashSet.contains(number)) {
                return number;
            }
            hashSet.add(number);
        }
        return 0;
    }
}

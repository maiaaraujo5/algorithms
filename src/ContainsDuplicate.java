import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5};
        boolean result= containDuplicate(nums);
        System.out.println(result);
    }

    public static boolean containDuplicate(int[] num) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int number : num) {
            if (hashSet.contains(number)){
                return true;
            }
            hashSet.add(number);
        }
        return false;
    }
}
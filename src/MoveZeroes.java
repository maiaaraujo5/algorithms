import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 11, 0, 0,90,50,70,0,500};
        int[] result = moveZeros(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] moveZeros(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                result[index] = num;
                index++;
            }
        }

        for (int i = result.length - 1; i < nums.length; i++) {
            result[i] = 0;
        }
        nums = result;
        return nums;
    }
}
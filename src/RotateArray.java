import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] result = rotate(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            result[index] = nums[i];
            index++;
        }

        for (int i = 0; i < nums.length - k; i++) {
            result[index] = nums[i];
            index++;
        }
        return result;
    }
}

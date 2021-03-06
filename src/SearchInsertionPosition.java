import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        int result = searchInsertPosition(array, 4);
        System.out.println(result);
    }

    public static int searchInsertPosition(int[] nums, int target) {
        int result = -1;

        for(int i = 0; i< nums.length; i++){

            if(nums[i] == target) {
                result = i;
            }

            else if (nums[nums.length - 1] < target){
                result = nums.length;
            }
            else if (nums[0] > target) {
                result = 0;
            }
        }

        for (int i = 0; i < nums.length -1; i++){
            if(nums[i] < target && nums[i+1] > target){
                result = i +1;
            }
        }

        return result;
    }
}

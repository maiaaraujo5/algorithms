public class FindPeakElement {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2};
        int solution = findPeakElement(array);
        System.out.println(solution);
    }

    public static int findPeakElement(int[] nums) {
        int start = 1;
        int end = nums.length - 2;

        if (nums.length == 1) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[0] && nums[nums.length - 1] > nums[end]) {
            return nums.length - 1;
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return 0;
    }
}

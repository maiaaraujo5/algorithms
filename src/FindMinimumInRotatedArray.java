public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 50, 1, 8, 8, 10};
        int result = findMin(arr);
        int max = findMax(arr);
        System.out.println(result);
        System.out.println(max);
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        //This means that array is already sorted. We can get the first position.
        if (nums[end] > nums[0]) {
            return nums[0];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        if (nums[end] > nums[0]) {
            return nums[end];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid - 1];
            }

            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
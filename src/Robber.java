public class Robber {
    public static void main(String[] args) {
        int[] houses = new int[]{1,2,3,1};
        int amount = robber(houses);
        System.out.println(amount);
    }

    public static int robber(int[] nums){
        int amount = 0;
        for(int i=0; i<nums.length;){
            amount += nums[i];
            i +=2;
        }
        return amount;
    }
}

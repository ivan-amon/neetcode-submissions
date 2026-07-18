class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int product = 1;
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            product = product * nums[i - 1];
            prefix[i] = product;
        }

        product = 1;
        suffix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            suffix[i] = product;
            System.out.println(suffix[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            output[i] = prefix[i] * suffix[i];
        }

        return output;
    }
}  

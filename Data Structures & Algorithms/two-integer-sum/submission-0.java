class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numberIndex = new HashMap<>();
        int[] twoSumResult = new int[2];

        for(int i = 0; i < nums.length; i++) {
            numberIndex.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if(numberIndex.containsKey(x)) {
                int j = numberIndex.get(x);
                if(i != j) {
                    twoSumResult[0] = i;
                    twoSumResult[1] = j;
                    return twoSumResult;
                }
            }
        }
        return twoSumResult;
    }
}

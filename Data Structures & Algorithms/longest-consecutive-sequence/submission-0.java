class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums) {
            numsSet.add(num);
        }

        List<Integer> startingNums = new ArrayList<>();

        for(int num : numsSet) {
            if(!numsSet.contains(num - 1)) startingNums.add(num);
        }

        int longestSeq = 1;
        for(int start : startingNums) {
            int currentSeq = 1;
            while(numsSet.contains(start + 1)) {
                currentSeq++;
                if(currentSeq > longestSeq) longestSeq = currentSeq;
                start++;
            }
        }

        return longestSeq;
    }
}

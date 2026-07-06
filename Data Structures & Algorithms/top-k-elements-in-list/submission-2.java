class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int highestFreq = 1;

        for(int num : nums) {
            int newValue = 1;
            if(frequencies.containsKey(num)) {
                newValue = frequencies.get(num) + 1;
            }
            if(newValue > highestFreq) highestFreq = newValue;
            frequencies.put(num, newValue);
        }
        
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < highestFreq; i++) {
            buckets.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            List<Integer> list = buckets.get(entry.getValue() - 1);
            list.add(entry.getKey());
        }

        int[] topK = new int[k];
        int indexTopK = 0;
        for(int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> list = buckets.get(i);

            for(int num : list) {
                topK[indexTopK] = num;
                indexTopK++;
                if(indexTopK == k) {
                    return topK;
                }
            }
        }
        return topK;
    }
}

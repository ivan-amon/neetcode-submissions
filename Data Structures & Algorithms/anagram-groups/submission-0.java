class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        Map<List<Integer>, List<String>> anagrams = new HashMap<>();

        for(String str : strs) {
            List<Integer> alphabet = new ArrayList<>();
            
            for(int i = 0; i < 26; i++) {
                alphabet.add(i, 0);
            }

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = c - 'a';
                int value = alphabet.get(index) + 1;
                alphabet.set(index, value);
            }

            if(!anagrams.containsKey(alphabet)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                anagrams.put(alphabet, list);
            } else {
                List<String> list = anagrams.get(alphabet);
                list.add(str);
            }
        }

        for(List<String> anagram : anagrams.values()) {
            group.add(anagram);
        }

        return group;
    }
}

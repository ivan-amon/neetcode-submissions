class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            int index = character - 'a';
            chars[index]++;
        }

        for(int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            int index = character - 'a';
            chars[index]--;
        }

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

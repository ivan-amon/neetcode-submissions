class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded_strs = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String slice = str.substring(j + 1, j + 1 + length);
            decoded_strs.add(slice);

            i = j + 1 + length;
        }
        return decoded_strs;
    }
}

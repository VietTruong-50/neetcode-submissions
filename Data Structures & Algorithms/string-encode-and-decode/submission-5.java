class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length())
              .append("#")
              .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find the '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the length of the string
            int length = Integer.parseInt(
                str.substring(i, j)
            );

            // Start position of actual string
            int start = j + 1;

            // Extract the string
            result.add(
                str.substring(start, start + length)
            );

            // Move to the next encoded string
            i = start + length;
        }

        return result;
    }
}
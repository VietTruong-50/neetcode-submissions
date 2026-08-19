class Solution {
     public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Đếm frequency của t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int required = need.size();

        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            // Nếu character này đã đủ số lượng cần thiết
            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // Window đã hợp lệ
            while (have == required) {

                // Kiểm tra xem có phải window nhỏ nhất không
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    resultLeft = left;
                    resultRight = right;
                }

                // Chuẩn bị remove s[left]
                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resultLeft, resultRight + 1);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip ký tự không phải chữ hoặc số ở bên trái
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip ký tự không phải chữ hoặc số ở bên phải
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // So sánh, không phân biệt hoa thường
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
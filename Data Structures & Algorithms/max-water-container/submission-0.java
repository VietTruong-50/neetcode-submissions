class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int area = 0;

        while(left < right) {
            int newArea = Math.min(heights[left], heights[right]) * (right - left);

            if (newArea > area) {
                area = newArea;
            }

            if (heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}

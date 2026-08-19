class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {

            // 1. Remove index đã ra khỏi window
            while (!deque.isEmpty()
                    && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove những phần tử nhỏ hơn nums[right]
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // 3. Add right
            deque.offerLast(right);

            // 4. Window đủ k phần tử
            if (right >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
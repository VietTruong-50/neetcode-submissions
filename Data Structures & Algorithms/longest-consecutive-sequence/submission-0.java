class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> consecutiveSeq = new HashSet<>();

        for (int num : nums) {
            consecutiveSeq.add(num);
        }

        int longest = 0;

        for (int num : consecutiveSeq) {
            if (!consecutiveSeq.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (consecutiveSeq.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
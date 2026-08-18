class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            if (countMap.isEmpty()) {
                return new int[0];
            }

            int key = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

            result[i] = key;
            countMap.remove(key);
        }

        return result;
    }
}

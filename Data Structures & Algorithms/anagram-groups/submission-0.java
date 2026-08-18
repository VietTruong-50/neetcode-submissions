class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            results.putIfAbsent(key, new ArrayList<>());
            results.get(key).add(s);
        }
        
        return new ArrayList<>(results.values());
    }

   
}

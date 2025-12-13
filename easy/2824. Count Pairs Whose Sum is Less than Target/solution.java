class Solution {
    public int countPairs(List<Integer> n, int t) {
        int ans = 0, len = n.size();
        for(int i = 0; i < len; ++i)
            for(int j = i + 1; j < len; ++j) 
                if(n.get(i) + n.get(j) < t) 
                    ++ans;
        return ans;
    }
}
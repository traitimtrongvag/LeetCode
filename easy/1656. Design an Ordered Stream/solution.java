class OrderedStream {

    int idx;
    String[] lt;
    int max;

    public OrderedStream(int n) {
        idx = 1;
        lt = new String[n + 1];
        max = n;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        lt[idKey] = value;

        while (idx <= max && lt[idx] != null) {
            ans.add(lt[idx]);
            idx++;
        }

        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
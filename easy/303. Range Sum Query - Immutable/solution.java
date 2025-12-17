class NumArray {
    private int[] prefixA;
    
    public NumArray(int[] nums) {
  
       
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i-1]+nums[i];
        }
        this.prefixA=nums;
    }
    
    public int sumRange(int left, int right) {
        if(left==0)
        {
            return prefixA[right];
        }
        return prefixA[right]-prefixA[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
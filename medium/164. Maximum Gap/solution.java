class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2) return 0;
        int op=0;
          for(int i =1;i<nums.length;i++)
          {
            op =Math.max(op,nums[i]-nums[i-1]);
          }
          return op;

    }
}
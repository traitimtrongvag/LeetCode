impl Solution {
    pub fn count_pairs(mut nums: Vec<i32>, target: i32) -> i32 {
        nums.sort_unstable();
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut count = 0;

        while left < right {
            if nums[left] + nums[right] < target {
                count += (right - left) as i32;
                left += 1;
            } else {
                right -= 1;
            }
        }

        count
    }
}
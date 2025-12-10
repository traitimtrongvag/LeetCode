impl Solution {
    pub fn added_integer(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        nums2.iter().max().unwrap() - nums1.iter().max().unwrap()
    }
}
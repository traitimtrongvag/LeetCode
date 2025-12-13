impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
         let n=nums.len() as i32;

        nums.iter().fold((n*(n+1))/2, |acc,&x| {acc-x})
    }
}
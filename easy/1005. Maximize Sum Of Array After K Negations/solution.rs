impl Solution {
    pub fn largest_sum_after_k_negations(mut nums: Vec<i32>, mut k: i32) -> i32 {
        nums.sort_unstable_by_key(|&k| k.abs());
        nums.into_iter()
            .enumerate()
            .rev()
            .fold(0, |acc, (i, num)| match (k == 0, i > 0, num.is_negative()) {
                (true, _, _) | (false, true, false) => acc + num,
                (false, true, true) => {
                    k -= 1;
                    acc - num
                }
                (false, false, _) => acc + if k & 1 == 1 { -num } else { num },
            })
    }
}
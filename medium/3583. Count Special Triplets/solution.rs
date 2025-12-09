impl Solution {
    pub fn special_triplets(nums: Vec<i32>) -> i32 {
        const MOD: i64 = 1_000_000_007;

        use std::collections::HashMap;
        let mut left: HashMap<i32, i64> = HashMap::new();
        let mut right: HashMap<i32, i64> = HashMap::new();

        for &x in &nums {
            *right.entry(x).or_insert(0) += 1;
        }

        let mut ans: i64 = 0;

        for &x in &nums {
            *right.get_mut(&x).unwrap() -= 1;

            let need = x * 2;
            let lc = *left.get(&need).unwrap_or(&0);
            let rc = *right.get(&need).unwrap_or(&0);

            ans = (ans + lc * rc) % MOD;

            *left.entry(x).or_insert(0) += 1;
        }

        ans as i32
    }
}
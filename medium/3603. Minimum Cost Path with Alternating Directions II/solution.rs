impl Solution {
  pub fn min_cost(m: i32, n: i32, cost: Vec<Vec<i32>>) -> i64 {
    let m = m as usize;
    let n = n as usize;

    let mut dp: Vec<usize> = (0..n).map(|i| i as usize + 1).collect();
    for i in 1..n {
      dp[i] += dp[i - 1] + cost[0][i] as usize;
    }

    for y in 1..m {
      dp[0] += cost[y][0] as usize + y + 1;
      for x in 1..n {
        dp[x] = dp[x].min(dp[x - 1]) + cost[y][x] as usize + (y + 1) * (x + 1);
      }
    }

    dp[n - 1] as i64 - cost[m - 1][n - 1] as i64
  }
}
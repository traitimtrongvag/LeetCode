impl Solution {
    pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        let n = code.len();
        let mut res = vec![0; n];
        
        if k == 0 {
            return res;
        }
        
        for i in 0..n {
            let mut sum = 0;
            if k > 0 {
                let mut count = k;
                let mut j = (i + 1) % n;
                while count > 0 {
                    sum += code[j];
                    j = (j + 1) % n;
                    count -= 1;
                }
            } else {
                let mut count = k.abs();
                let mut j = (i + n - 1) % n;
                while count > 0 {
                    sum += code[j];
                    j = (j + n - 1) % n;
                    count -= 1;
                }
            }
            res[i] = sum;
        }
        
        res
    }
}
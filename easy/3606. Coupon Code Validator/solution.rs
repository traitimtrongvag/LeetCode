impl Solution {
    pub fn validate_coupons(code: Vec<String>, business_line: Vec<String>, is_active: Vec<bool>) -> Vec<String> {
        let n = code.len();
        let mut xs: Vec<(String, String)> = Vec::new();

        for i in 0..n {
            let code = &code[i];
            let b = &business_line[i];
            let a = is_active[i];

            if a
               && (b == "electronics" || b == "grocery" || b == "pharmacy" || b == "restaurant")
               && !code.is_empty()
               && code.chars().all(|c | c.is_ascii_alphanumeric() || c == '_' )
            {
                xs.push((b.clone(), code.clone()));
            }
        };

        xs.sort();

        xs.into_iter().map(|x| x.1).collect()
    }
}
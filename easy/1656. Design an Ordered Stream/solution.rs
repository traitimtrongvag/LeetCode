pub struct OrderedStream {
    stream: Vec<Option<String>>,
    ptr: usize,
}

impl OrderedStream {
    pub fn new(n: i32) -> Self {
        Self {
            stream: vec![None; n as usize],
            ptr: 0,
        }
    }
    
    pub fn insert(&mut self, idKey: i32, value: String) -> Vec<String> {
        let idx = (idKey - 1) as usize;
        self.stream[idx] = Some(value);
        
        let capacity = self.stream.len() - self.ptr;
        let mut res = Vec::with_capacity(capacity);
        let n = self.stream.len();
        while self.ptr < n {
            if let Some(val) = self.stream[self.ptr].take() {
                res.push(val);
                self.ptr += 1;
            } else {
                break;
            }
        }
        res
    }
}
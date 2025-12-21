class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<operations.length;i++){
            String s = operations[i];
            if(s.equals("D") && !st.isEmpty()){
                st.push(st.peek() *2);
            }
            else if(s.equals("C") && !st.isEmpty()){     //if - else ke sath run as agar sabhi if so not run
                st.pop();
            }
            else if(s.equals("+") && !st.isEmpty()){
                int a = st.pop();
                int b= st.pop();
                int result = a+b;
                st.push(b);
                st.push(a);
                st.push(result);
            }
            else{
                int a =Integer.parseInt(s);
                st.push(a);
            }
        }
        int totalSumStack = 0;
        for(int val : st){
            totalSumStack+=val;
        }
        return totalSumStack;

    }
}
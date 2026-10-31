class Solution {

    public int solve(String exp, int val1, int val2){
        if(exp.equals("+")){
            return val1 + val2;
        }else if(exp.equals("-")){
            return val1-val2;
        }else if(exp.equals("*")){
            return val1*val2;
        }else{
            return val1/val2;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = solve(tokens[i], val1, val2);
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}

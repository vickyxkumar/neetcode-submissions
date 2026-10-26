class Solution {

    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.add(ch);
            }

            if(stack.isEmpty()) return false;

            char peek = stack.peek();
            
            if((peek == '(' && ch == ')') || (peek == '{' && ch == '}') || (peek == '[' || peek == ']')){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public void dfs(int n1, int n2, List<String> ans, StringBuilder newStr){
        if(n1 > n2) return;

        if(n1 == 0 & n2 == 0){
            // check whether newStr is well performed parantheses or not.

            if(isValid(newStr.toString())){
                // System.out.println(newStr.toString());
                ans.add(newStr.toString());
            }

            return;
        }

        if(n1 != 0){
            newStr.append("(");
            dfs(n1-1, n2, ans, newStr);
            newStr.deleteCharAt(newStr.length()-1);
        }

        if(n2 != 0){
            newStr.append(")");
            dfs(n1, n2 - 1, ans, newStr);
            newStr.deleteCharAt(newStr.length()-1);
        }

        System.out.println(newStr.toString());
        
    }



    public List<String> generateParenthesis(int n) {
        // String fixed = "()";
        // StringBuilder str = new StringBuilder("");
        // for(int i = 0; i< n; i++){
        //     str.append(fixed);
        // }

        List<String> ans = new ArrayList<>();
        // boolean [] taken = new boolean[n*2];
        // System.out.println(str.toString());
        dfs(n, n, ans, new StringBuilder(""));
        return ans;
    }
}

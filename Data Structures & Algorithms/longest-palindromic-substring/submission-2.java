class Solution {
    // the quickest I can think is that take the considered all the string and check is that is palindrome or not. If then update 
    // the maxLen
    // t.c O(n^2 * n/2) = o(n)
    // s.c o(1)

    // the second thought process for this problem is expand on both side using i and j pointer. The worst time complexity is o(n^3)
    public String longestPalindrome(String s) {
        int j = 0, n = s.length();

        String ans = "";
        
        while(j < n){
            int l = j;
            while(j+1 < n && s.charAt(j) == s.charAt(j+1)){
                j++;
            }
            int r = j;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }

            if(ans.length() < (r-l-1)){
                // need to update the ans string;
                ans = s.substring(l+1, r);
            }
            j++;
        }
        return ans;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        String pattern = needle + "@" + haystack;
        int [] table = computeTable(pattern);
        int m = needle.length();
        for(int i = m+1; i < table.length; i++){
            if(table[i] == m){
                return i - 2 * m;
            }
        }   

        return -1;
    }

    public int[] computeTable(String pattern){
        int n = pattern.length();
        int table[] = new int[n];
        int len = 0, i = 1;
        while(i < n){
            if(pattern.charAt(len) == pattern.charAt(i)){
                len++;
                table[i] = len;
                i++;
            }else{
                if(len == 0){
                    table[i] = 0;
                    i++;
                }else{
                    len = table[len-1];
                }
            }
        }

        return table;
    }


}
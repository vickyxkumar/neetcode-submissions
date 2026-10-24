class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i< n; i++){
            char ch1 = s1.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);

            char ch2 = s2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }

        int i = 0, j = n;
        
        while(j < m){
            if(map1.equals(map2)){
                return true;
            }

            char leftChar = s2.charAt(i);
            map2.put(leftChar, map2.get(leftChar)-1);
            if(map2.get(leftChar) == 0) map2.remove(leftChar);

            char rightChar = s2.charAt(j);
            map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);

            i++;
            j++;
        }
        

        return map1.equals(map2);


    }
}

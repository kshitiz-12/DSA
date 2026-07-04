class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int [] prefix = new int [words.length];
        for(int i =0;i<words.length;i++){
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length()-1);

            Boolean isvowel = (first=='a'||first=='e'||first=='i'||first=='o'||first=='u')
                 && (last=='a'||last=='e'||last=='i'||last=='o'||last=='u');
        

            if(i==0){
                prefix[i]=isvowel ? 1:0;
            }
            else{
                prefix[i]=prefix[i-1]+(isvowel?1:0);
            }
        }
        int [] ans = new int [queries.length];
        for (int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left==0){
                ans[i]=prefix[right];
            }
            else{
                ans[i]=prefix[right]-prefix[left-1];
            }
        }
        return ans;


    }
}